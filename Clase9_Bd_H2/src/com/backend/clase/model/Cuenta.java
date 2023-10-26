package com.backend.clase.model;

public class Cuenta {
	private int id;
	private String nombre;
	private double saldo;
	private int numeroCuenta;

	public Cuenta(int id, String nombre,int numeroCuenta,double saldo) {
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
		this.numeroCuenta = numeroCuenta;
	}

	public Cuenta(String nombre, int numeroCuenta, double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
		this.numeroCuenta = numeroCuenta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	@Override
	public String toString() {
		return "Cuenta{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", saldo=" + saldo +
				", numeroCuenta=" + numeroCuenta +
				'}';
	}
}
