package br.com.msantos.estacionamento.descontos;

import org.javamoney.moneta.Money;

import br.com.msantos.estacionamento.Permanencia;
import br.com.msantos.estacionamento.Veiculo;

public class TerceiraHora extends TemplateCalculoDesconto implements Desconto {

	private Desconto proximo;

	public Money desconta(Permanencia permanencia, Veiculo veiculo) {

		if (permanencia.getPermanencia().toMinutes() <= 180) {

			return calcula(permanencia, PrecosDescontos.DESCONTO_TERCEIRA_HORA, veiculo);
		}

		return proximo.desconta(permanencia, veiculo);
	}

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
