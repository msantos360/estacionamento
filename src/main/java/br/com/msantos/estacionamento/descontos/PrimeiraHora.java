package br.com.msantos.estacionamento.descontos;

import org.javamoney.moneta.Money;

import br.com.msantos.estacionamento.Permanencia;
import br.com.msantos.estacionamento.Veiculo;

public class PrimeiraHora extends TemplateCalculoDesconto implements Desconto {

	private Desconto proximo;

	public Money desconta(Permanencia permanencia, Veiculo veiculo) {

		if (permanencia.getPermanencia().toMinutes() <= 60) {
			
			return calcula(permanencia, PrecosDescontos.DESCONTO_PRIMEIRA_HORA, veiculo);
		}

		return proximo.desconta(permanencia, veiculo);
	}

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
