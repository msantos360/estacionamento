package br.com.msantos.estacionamento.descontos;

import org.javamoney.moneta.Money;

import br.com.msantos.estacionamento.Permanencia;
import br.com.msantos.estacionamento.Veiculo;

public class CalculadorDescontos {

	public Money calcula(Permanencia permanencia, Veiculo veiculo) {

		Desconto d0 = new Tolerancia();
		Desconto d1 = new PrimeiraHora();
		Desconto d2 = new SegundaHora();
		Desconto d3 = new TerceiraHora();
		Desconto d4 = new SemDesconto();

		d0.setProximo(d1);
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);

		return d0.desconta(permanencia, veiculo);
	}
}
