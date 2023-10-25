package com.facade_1.model;

public class Cuenta {
	private  String dni;
	private  double saldo;

	public Cuenta(String dni, double saldo) {
		this.dni = dni;
		this.saldo = saldo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
