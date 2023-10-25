package com.facade.facade_3.model;

public class ProductoSuper {
	private String nombre;
	private String tipo;

	public ProductoSuper(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "ProductoSuper{" +
				"nombre='" + nombre + '\'' +
				", tipo='" + tipo + '\'' +
				'}';
	}
}
