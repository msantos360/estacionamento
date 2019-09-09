package br.com.msantos.estacionamento.descontos;

import org.javamoney.moneta.Money;

import br.com.msantos.estacionamento.Permanencia;

public class SegundaHora extends TemplateCalculoDesconto implements Desconto {

	private Desconto proximo;

	public Money desconta(Permanencia permanencia) {

		if (permanencia.getPermanencia().toMinutes() <= 120) {

			return calcula(permanencia, PrecosDescontos.DESCONTO_SEGUNDA_HORA);
		}

		return proximo.desconta(permanencia);
	}

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}


}
