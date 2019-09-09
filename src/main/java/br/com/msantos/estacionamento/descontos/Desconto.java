package br.com.msantos.estacionamento.descontos;

import org.javamoney.moneta.Money;

import br.com.msantos.estacionamento.Permanencia;

public interface Desconto {

	public Money desconta(Permanencia permanencia);

	public void setProximo(Desconto proximo);

}
