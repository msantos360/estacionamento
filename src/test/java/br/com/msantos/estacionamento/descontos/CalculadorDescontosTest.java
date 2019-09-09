package br.com.msantos.estacionamento.descontos;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import org.javamoney.moneta.Money;
import org.junit.Before;
import org.junit.Test;

import br.com.msantos.estacionamento.Permanencia;
import br.com.msantos.estacionamento.TipoVeiculo;
import br.com.msantos.estacionamento.Veiculo;

public class CalculadorDescontosTest {

	private Permanencia permanencia;

	private Money valorEsperadoTolerancia;
	private Money valorEsperadoPrimeiraHora;
	private Money valorEsperadoSegundaHora;
	private Money valorEsperadoTerceiraHora;
	private Money valorEsperadoTerceiraHoraSuv;
	private Money valorEsperadoTerceiraHoraCaminhao;
//	private Money valorEsperadoQuartaHora;

	@Before
	public void setHoraDeEntradasESaidas() {

		valorEsperadoTolerancia = Money.of(BigDecimal.ZERO, PrecosDescontos.MOEDA_BRASILEIRA);
		valorEsperadoPrimeiraHora = Money.of(BigDecimal.valueOf(8.00), PrecosDescontos.MOEDA_BRASILEIRA);
		valorEsperadoSegundaHora = Money.of(BigDecimal.valueOf(7.20), PrecosDescontos.MOEDA_BRASILEIRA);
		valorEsperadoTerceiraHora = Money.of(BigDecimal.valueOf(21.60), PrecosDescontos.MOEDA_BRASILEIRA);
		valorEsperadoTerceiraHoraSuv = Money.of(BigDecimal.valueOf(32.40), PrecosDescontos.MOEDA_BRASILEIRA);
		valorEsperadoTerceiraHoraCaminhao = Money.of(BigDecimal.valueOf(43.20), PrecosDescontos.MOEDA_BRASILEIRA);

	}

	@Test
	public void deveRetornarZeroParaAToleranciaMenorQueDezMinutos() {
	
		LocalDateTime entrada = LocalDateTime.of(2019, Month.APRIL, 20, 9, 00);
		LocalDateTime saida = LocalDateTime.of(2019, Month.APRIL, 20, 9, 10);
		
		new Veiculo("GTP-5696", "Paulo", TipoVeiculo.MOTO);

		permanencia = new Permanencia(entrada, saida, new Veiculo("KOI-2698", "Paulo", TipoVeiculo.MOTO));

		assertEquals(valorEsperadoTolerancia, new CalculadorDescontos().calcula(permanencia));
	}
	
	@Test
	public void deveRetornarOValorEsperadoParaAPrimeiraHora() {

		LocalDateTime entrada = LocalDateTime.of(2019, Month.APRIL, 20, 9, 00);
		LocalDateTime saida = LocalDateTime.of(2019, Month.APRIL, 20, 10, 00);

		permanencia = new Permanencia(entrada, saida, new Veiculo("KOI-2698", "Paulo", TipoVeiculo.CARRO));
		
		assertEquals(valorEsperadoPrimeiraHora, new CalculadorDescontos().calcula(permanencia));
		
	}
	
	@Test
	public void deveRetornarOValorEsperadoParaASegundaHoraDaMoto() {

		LocalDateTime entrada = LocalDateTime.of(2019, Month.APRIL, 20, 9, 00);
		LocalDateTime saida = LocalDateTime.of(2019, Month.APRIL, 20, 11, 00);

		permanencia = new Permanencia(entrada, saida, new Veiculo("KOI-2698", "Paulo", TipoVeiculo.MOTO));

		assertEquals(valorEsperadoSegundaHora, new CalculadorDescontos().calcula(permanencia));
		
	}
	
	@Test
	public void deveRetornarOValorEsperadoParaATerceiraHoraDoCarro() {

		LocalDateTime entrada = LocalDateTime.of(2019, Month.APRIL, 20, 9, 00);
		LocalDateTime saida = LocalDateTime.of(2019, Month.APRIL, 20, 12, 00);

		permanencia = new Permanencia(entrada, saida, new Veiculo("KOI-2698", "Paulo", TipoVeiculo.CARRO));

		assertEquals(valorEsperadoTerceiraHora, new CalculadorDescontos().calcula(permanencia));
		
	}
	
	@Test
	public void deveRetornarOValorEsperadoParaATerceiraHoraDoSuv() {

		LocalDateTime entrada = LocalDateTime.of(2019, Month.APRIL, 20, 9, 00);
		LocalDateTime saida = LocalDateTime.of(2019, Month.APRIL, 20, 12, 00);

		permanencia = new Permanencia(entrada, saida, new Veiculo("KOI-2698", "Paulo", TipoVeiculo.SUV));

		assertEquals(valorEsperadoTerceiraHoraSuv, new CalculadorDescontos().calcula(permanencia));
		
	}
	
	@Test
	public void deveRetornarOValorEsperadoParaATerceiraHoraDoCaminhao() {

		LocalDateTime entrada = LocalDateTime.of(2019, Month.APRIL, 20, 9, 00);
		LocalDateTime saida = LocalDateTime.of(2019, Month.APRIL, 20, 12, 00);

		permanencia = new Permanencia(entrada, saida, new Veiculo("KOI-2698", "Paulo", TipoVeiculo.CAMINHAO));

		assertEquals(valorEsperadoTerceiraHoraCaminhao, new CalculadorDescontos().calcula(permanencia));
		
	}

}
