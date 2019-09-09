package br.com.msantos.estacionamento.descontos;

import org.javamoney.moneta.Money;

import br.com.msantos.estacionamento.Permanencia;

public class Tolerancia extends TemplateCalculoDesconto implements Desconto{

	private Desconto proximo;

	public Money desconta(Permanencia permanencia) {
		
		if (permanencia.getPermanencia().toMinutes() <= 10) {

			return calcula(permanencia, PrecosDescontos.DESCONTO_TOLERANCIA);
		}

		return proximo.desconta(permanencia);
	}

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
