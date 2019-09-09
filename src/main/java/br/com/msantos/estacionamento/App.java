package br.com.msantos.estacionamento;

import java.math.BigDecimal;

import br.com.msantos.estacionamento.descontos.CalculadorDescontos;

public class App {

	private Veiculo veiculo;
	private Permanencia permanencia;
	private BigDecimal totalAPagar;

	public App(Veiculo veiculo, Permanencia permanencia) {

		this.veiculo = veiculo;
		this.permanencia = permanencia;

		if (veiculo == null | permanencia == null) {
			throw new IllegalArgumentException("Veiculo e Permanencia são requeridos.");
		}

		calculaValor();
	}

	private void calculaValor() {

		this.totalAPagar = new CalculadorDescontos().calcula(permanencia, veiculo).getNumberStripped();
	}

	public BigDecimal getTotalAPagar() {
		return totalAPagar;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public Permanencia getPermanencia() {
		return permanencia;
	}

}
