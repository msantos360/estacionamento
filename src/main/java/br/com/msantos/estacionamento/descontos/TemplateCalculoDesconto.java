package br.com.msantos.estacionamento.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryOperators;

import br.com.msantos.estacionamento.Permanencia;
import br.com.msantos.estacionamento.Veiculo;

public abstract class TemplateCalculoDesconto {

	protected Money calcula(Permanencia permanencia, BigDecimal desconto, Veiculo veiculo) {

		Money valorFixadoHora = Money.of(PrecosDescontos.VALOR_FIXADO_HORA, PrecosDescontos.MOEDA_BRASILEIRA);

		Money valorFixadoMinuto = valorFixadoHora.divide(60);

		Money subTotal = valorFixadoMinuto.multiply(permanencia.getPermanencia().toMinutes());

		Money totalAPagarComDesconto = subTotal.add(subTotal.with(MonetaryOperators.percent(desconto)));

		Money descontoAcrescimoTipoVeiculo = totalAPagarComDesconto
				.with(MonetaryOperators.percent(veiculo.getTipoVeiculo().getDescontoAcrescimo()));

		return totalAPagarComDesconto.add(descontoAcrescimoTipoVeiculo)
				.with(MonetaryOperators.rounding(RoundingMode.HALF_UP, 2));
	}

}
