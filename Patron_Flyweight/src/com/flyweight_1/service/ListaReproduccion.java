package com.flyweight_1.service;

import com.flyweight_1.model.Cancion;

import java.util.HashMap;

public class ListaReproduccion {
	private String nombre;
	private HashMap<String, Cancion>canciones = new HashMap<>();

	public ListaReproduccion(String nombre) {
		this.nombre = nombre;
	}
	public void agregarCancion(Cancion cancion){
		canciones.put(cancion.getNombre(),cancion);

	}
	public void  eliminarCancion(String nombre){
		canciones.remove(nombre);
	}
	public  void mostrarListaReproduccion(){
		System.out.println("Lista de Reproduccion:  "+ nombre);
		for (Cancion cancion : canciones.values()) {
			System.out.println(cancion.toString());

		}
	}
}
