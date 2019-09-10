package br.com.msantos.estacionamento;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Permanencia {

	private LocalDateTime entrada;

	private LocalDateTime saida;

	private Duration permanencia;

	public Permanencia(LocalDateTime entrada, LocalDateTime saida) {
		this.entrada = entrada;
		this.saida = saida;

		if (entrada == null || saida == null) {
			throw new NullPointerException("Os valores de entrada e de saída devem ser setados");
		}
		
		calculaPermanencia();
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
