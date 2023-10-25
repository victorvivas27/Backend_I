package com.flyweight_3.model;

public class Arbol {
	private  int alto;
	private int ancho;
	private  String color;
	private String tipo;
	private  static  int contador;

	public Arbol(int alto, int ancho, String color, String tipo) {
		this.alto = alto;
		this.ancho = ancho;
		this.color = color;
		this.tipo = tipo;
		contador++;
		System.out.println("Exisistencias: "+contador);
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Arbol.contador = contador;
	}


}

