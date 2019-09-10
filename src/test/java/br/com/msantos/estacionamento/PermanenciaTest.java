package br.com.msantos.estacionamento;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

public class PermanenciaTest {

	private LocalDateTime entrada;
	
	private LocalDateTime saida;
	
	private Permanencia permanenciaCalculada;
	
	@Before
	public void setValores() {
		entrada = LocalDateTime.of(2019, Month.APRIL, 20, 9, 30);
		saida = LocalDateTime.of(2019, Month.APRIL, 20, 11, 30);
	}

	@Test
	public void deveCalcularAPermanenciaEntreDoisHorarios() {

		permanenciaCalculada = new Permanencia(entrada, saida);

		Duration permanenciaEsperada = Duration.ofMinutes(120);

		assertEquals(permanenciaEsperada, permanenciaCalculada.getPermanencia());
	}

	@Test(expected = NullPointerException.class)
	public void deveLancarUmaExcessaoQuandoUmDosValoresForemIguaisANull() {

		permanenciaCalculada = new Permanencia(entrada, null);

		permanenciaCalculada.getPermanencia();
	}

}
