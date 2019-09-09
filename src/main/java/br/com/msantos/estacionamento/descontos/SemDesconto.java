package br.com.msantos.estacionamento.descontos;

import java.math.BigDecimal;

import org.javamoney.moneta.Money;

import br.com.msantos.estacionamento.Permanencia;
import br.com.msantos.estacionamento.Veiculo;

public class SemDesconto implements Desconto {

	public Money desconta(Permanencia permanencia, Veiculo veiculo) {
		return Money.of(BigDecimal.ZERO, PrecosDescontos.MOEDA_BRASILEIRA);
	}

	public void setProximo(Desconto proximo) {
		
	}

}
