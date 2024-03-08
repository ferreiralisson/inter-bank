package br.com.inter.model;

public class Conta {

	private Integer numeroConta;
	private String nomeCliente;

	public Conta(Integer numeroConta, String nomeCliente) {
		this.numeroConta = numeroConta;
		this.nomeCliente = nomeCliente;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

}
