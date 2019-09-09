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
	
	private Veiculo veiculo;

	@Before
	public void setValores() {
		entrada = LocalDateTime.of(2019, Month.APRIL, 20, 9, 30);
		saida = LocalDateTime.of(2019, Month.APRIL, 20, 11, 30);
		
		veiculo = new Veiculo("GTP-5696", "Paulo", TipoVeiculo.CARRO);
	}

	@Test
	public void deveCalcularAPermanenciaEntreDoisHorarios() {

		permanenciaCalculada = new Permanencia(entrada, saida, veiculo);

		Duration permanenciaEsperada = Duration.ofMinutes(120);

		assertEquals(permanenciaEsperada, permanenciaCalculada.getPermanencia());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarUmaExcessaoQuandoUmDosValoresForemIguaisANull() {

		permanenciaCalculada = new Permanencia(entrada, null, veiculo);

		permanenciaCalculada.getPermanencia();
	}

}
