package br.com.msantos.estacionamento.descontos;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryOperators;

import br.com.msantos.estacionamento.Permanencia;
import br.com.msantos.estacionamento.TipoVeiculo;
import br.com.msantos.estacionamento.Veiculo;

public abstract class TemplateCalculoDesconto {

	private TipoVeiculo tipoVeiculo;

	protected Money calcula(Permanencia permanencia, BigDecimal desconto, Veiculo veiculo) {

		this.tipoVeiculo = veiculo.getTipoVeiculo();

		Money valorFixadoHora = Money.of(PrecosDescontos.VALOR_FIXADO_HORA, PrecosDescontos.MOEDA_BRASILEIRA);
		
		Money valorFixadoMinuto = valorFixadoHora.divide(60);

		Money subTotal = valorFixadoMinuto.multiply(permanencia.getPermanencia().toMinutes());

		Money totalAPagarComDesconto = subTotal.add(subTotal.with(MonetaryOperators.percent(desconto)));

		Money descontoAcrescimoTipoVeiculo = definePrecoPorTipoVeiculo(totalAPagarComDesconto);

		return totalAPagarComDesconto.add(descontoAcrescimoTipoVeiculo)
				.with(MonetaryOperators.rounding(RoundingMode.HALF_UP, 2));
	}

	private Money definePrecoPorTipoVeiculo(Money totalAPagar) {

		if (TipoVeiculo.MOTO.equals(tipoVeiculo)) {
			return totalAPagar.with(MonetaryOperators.percent(PrecosDescontos.DESCONTO_MOTO));

		}
		if (TipoVeiculo.CARRO.equals(tipoVeiculo)) {
			return totalAPagar.with(MonetaryOperators.percent(PrecosDescontos.DESCONTO_CARRO));

		}
		if (TipoVeiculo.SUV.equals(tipoVeiculo)) {
			return totalAPagar.with(MonetaryOperators.percent(PrecosDescontos.ACRESCIMO_SUV));

		}
		if (TipoVeiculo.CAMINHAO.equals(tipoVeiculo)) {
			return totalAPagar.with(MonetaryOperators.percent(PrecosDescontos.ACRESIMO_CAMINHAO));

		}
	
		throw new RuntimeException("Tipo de veiculo não definido");

	}

}
