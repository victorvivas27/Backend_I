package com.facade.facade_2.model;

public class Vuelo {
	private String numeroVuelo;
	private String aerolinea;
	private String fechaSalida;
	private String fechaLlegada;
	private double precio;

	public void Hotel(String numeroVuelo, String aerolinea, String fechaSalida, String fechaLlegada, double precio) {
		this.numeroVuelo = numeroVuelo;
		this.aerolinea = aerolinea;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.precio = precio;
	}

	public String getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Hotel{" +
				"numeroVuelo='" + numeroVuelo + '\'' +
				", aerolinea='" + aerolinea + '\'' +
				", fechaSalida='" + fechaSalida + '\'' +
				", fechaLlegada='" + fechaLlegada + '\'' +
				", precio=" + precio +
				'}';
	}
}
