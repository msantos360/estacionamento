package br.com.msantos.estacionamento.descontos;

import org.javamoney.moneta.Money;

import br.com.msantos.estacionamento.Permanencia;
import br.com.msantos.estacionamento.Veiculo;

public interface Desconto {

	public Money desconta(Permanencia permanencia, Veiculo veiculo);

	public void setProximo(Desconto proximo);

}
