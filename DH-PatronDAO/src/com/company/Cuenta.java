package com.company;

public class Cuenta {
	private  int numero;
	private  double saldo;
	private EstrategiaExtraccion estrategiaExtraccion;


	public  void setEstrategiaExtraccion(EstrategiaExtraccion estrategiaExtraccion){
		this.estrategiaExtraccion=estrategiaExtraccion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public  boolean extraer( double monto){
		return estrategiaExtraccion.extraer(this,monto);
	}
}
