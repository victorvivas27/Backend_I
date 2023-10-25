package com.facade.facade_2.model;

public class Hotel {
	private String nombre;
	private String ubicacion;
	private String fechaInicio;
	private String fechaFin;
	private double tarifa;

	public Hotel(String nombre, String ubicacion, String fechaInicio, String fechaFin, double tarifa) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tarifa = tarifa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	@Override
	public String toString() {
		return "Hotel{" +
				"nombre='" + nombre + '\'' +
				", ubicacion='" + ubicacion + '\'' +
				", fechaInicio='" + fechaInicio + '\'' +
				", fechaFin='" + fechaFin + '\'' +
				", tarifa=" + tarifa +
				'}';
	}
}
