package com.flyweigtht.model;

public class Comida {
	private String tipoComida;
	private int precio;
	private boolean tieneLechuga;

	// Constructor de la clase Comida
	public Comida(String tipoComida) {
		this.tipoComida = tipoComida;
	}

	// Métodos getter y setter para acceder a los atributos
	public String getTipoComida() {
		return tipoComida;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean isTieneLechuga() {
		return tieneLechuga;
	}

	public void setTieneLechuga(boolean tieneLechuga) {
		this.tieneLechuga = tieneLechuga;
	}

	// Método para mostrar la descripción de la comida
	public void descripcionDeLaComida() {
		System.out.println("Es un/una " + getTipoComida() + " Que sale " + getPrecio());
	}
}
