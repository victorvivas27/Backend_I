package com.facade.facade_3.model;

public class TarjetaBanco {
	private String numero;
	private String banco;

	public TarjetaBanco(String numero, String banco) {
		this.numero = numero;
		this.banco = banco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	@Override
	public String toString() {
		return "TarjetaBanco{" +
				"numero='" + numero + '\'' +
				", banco='" + banco + '\'' +
				'}';
	}
}
