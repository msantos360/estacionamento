package br.com.msantos.estacionamento;

public class Veiculo {

	private String placa;

	private String cliente;

	private TipoVeiculo tipoVeiculo;

	public Veiculo(String placa, String cliente, TipoVeiculo tipoVeiculo) {
		this.placa = placa;
		this.cliente = cliente;
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public String getCliente() {
		return cliente;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

}
