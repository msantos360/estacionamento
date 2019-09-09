package br.com.msantos.estacionamento.descontos;

import java.math.BigDecimal;

import org.javamoney.moneta.Money;

import br.com.msantos.estacionamento.Permanencia;

public class SemDesconto implements Desconto {

	public Money desconta(Permanencia permanencia) {
		return Money.of(BigDecimal.ZERO, PrecosDescontos.MOEDA_BRASILEIRA);
	}

	public void setProximo(Desconto proximo) {
		
	}

}
