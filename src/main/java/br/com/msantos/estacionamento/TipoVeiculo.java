package br.com.msantos.estacionamento;

import java.math.BigDecimal;

/**Valores de descontos ou acréstimo por tipo de veículo são em porcentagem
 * Para descontos: adicionar o sinal "-" (sinal de menos)
 * Para acréstimos: adicionar somente o número
 * Caso contrário adicionar 0**/
public enum TipoVeiculo {

	MOTO (BigDecimal.valueOf(-50)),
	CARRO (BigDecimal.ZERO),
	SUV (BigDecimal.valueOf(50)),
	CAMINHAO (BigDecimal.valueOf(100));

	private final BigDecimal descontoAcrescimo;

	TipoVeiculo(BigDecimal descontoAcrescimo) {

		this.descontoAcrescimo = descontoAcrescimo;
	}

	public BigDecimal getDescontoAcrescimo() {
		return this.descontoAcrescimo;
	}

}
