package br.com.msantos.estacionamento;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

public class VeiculoTest {

	@Test(expected = NullPointerException.class)
	public void deveRetornaUmaExcepitionQuandoNaoForDeclaradoOTipoDeVeiculo() {

		LocalDateTime entrada = LocalDateTime.of(2019, Month.APRIL, 20, 9, 00);
		LocalDateTime saida = LocalDateTime.of(2019, Month.APRIL, 20, 10, 33);

		Veiculo veiculo = new Veiculo("GTP-5696", "Paulo", null);

		Permanencia permanencia = new Permanencia(entrada, saida);

		App app = new App(veiculo, permanencia);
		
		BigDecimal valorCalculadoEsperado = BigDecimal.valueOf(16.74);
		
		assertEquals(valorCalculadoEsperado, app.getTotalAPagar());
	}

}
