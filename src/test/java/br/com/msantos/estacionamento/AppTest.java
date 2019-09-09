package br.com.msantos.estacionamento;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

public class AppTest {

	@Test
	public void deveRetornarOPrecoCalculadoPorHoraEPorTipoDeVeiculo() {

		LocalDateTime entrada = LocalDateTime.of(2019, Month.APRIL, 20, 9, 00);
		LocalDateTime saida = LocalDateTime.of(2019, Month.APRIL, 20, 10, 33);

		Veiculo veiculo = new Veiculo("GTP-5696", "Paulo", TipoVeiculo.SUV);

		Permanencia permanencia = new Permanencia(entrada, saida);

		App app = new App(veiculo, permanencia);
		
		BigDecimal valorCalculadoEsperado = BigDecimal.valueOf(16.74);
		
		assertEquals(valorCalculadoEsperado, app.getTotalAPagar());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveRetornarUmaExceptionQuandoAppRecebaValoresNull() {

		new App(null, null);
		
	}
	

}
