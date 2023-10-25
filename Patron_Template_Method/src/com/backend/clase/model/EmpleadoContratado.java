package com.backend.clase.model;

public class EmpleadoContratado extends Empleado {
	private double cantidadHora;
	private double valorHora;

	public EmpleadoContratado(String nombre, String apellido, String numeroCuenta, double cantidadHora, double valorHora) {
		super(nombre, apellido, numeroCuenta);
		this.cantidadHora = cantidadHora;
		this.valorHora = valorHora;
	}

	public double getCantidadHora() {
		return cantidadHora;
	}

	public void setCantidadHora(double cantidadHora) {
		this.cantidadHora = cantidadHora;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
}

