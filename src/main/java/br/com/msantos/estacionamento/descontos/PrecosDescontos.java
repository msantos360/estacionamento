package br.com.msantos.estacionamento.descontos;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

public abstract class PrecosDescontos {

	/**Definição da moeda para calculo**/
	public static final CurrencyUnit MOEDA_BRASILEIRA = Monetary.getCurrency("BRL");

	/**Valor da hora em R$**/
	public static final BigDecimal VALOR_FIXADO_HORA = BigDecimal.valueOf(8.00);

	//Definições dos descontos por hora em porcentagem %
	public static final BigDecimal DESCONTO_TOLERANCIA = BigDecimal.valueOf(-100);

	public static final BigDecimal DESCONTO_PRIMEIRA_HORA = BigDecimal.ZERO;

	public static final BigDecimal DESCONTO_SEGUNDA_HORA = BigDecimal.valueOf(-10);

	public static final BigDecimal DESCONTO_TERCEIRA_HORA = BigDecimal.valueOf(-10);

	public static final BigDecimal DESCONTO_QUARTA_HORA = BigDecimal.valueOf(-15);

	public static final BigDecimal DESCONTO_QUINTA_HORA = BigDecimal.valueOf(-15);

	public static final BigDecimal DESCONTO_SEXTA_HORA = BigDecimal.valueOf(-20);

}
