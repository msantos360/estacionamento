package br.com.msantos.estacionamento;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Permanencia {

	private LocalDateTime entrada;

	private LocalDateTime saida;

	private Duration permanencia;

	private Veiculo veiculo;

	public Permanencia(LocalDateTime entrada, LocalDateTime saida, Veiculo veiculo) {
		this.entrada = entrada;
		this.saida = saida;
		this.veiculo = veiculo;
		
		calculaPermanencia();
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public Duration getPermanencia() {
		return permanencia;
	}
	
	private void calculaPermanencia() {
		if (entrada == null || saida == null) {
			throw new IllegalArgumentException("Os valores de entrada e de saída devem ser setados");
		}
		permanencia = Duration.between(entrada, saida);
	}

	@Override
	public String toString() {

		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String entradaTxt = "Horário entrada:\t" + entrada.format(dataFormatada);
		String saidaTxt = "\nHorário saída:\t\t" + saida.format(dataFormatada);
		String permanenciaTxt = "\nPermanencia:\t\t" + permanencia;

		return entradaTxt + saidaTxt + permanenciaTxt;
	}

}
