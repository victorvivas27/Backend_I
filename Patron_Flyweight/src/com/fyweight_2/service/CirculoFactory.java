package com.fyweight_2.service;

import com.fyweight_2.model.Circulo;

import java.util.HashMap;
import java.util.Map;

public class CirculoFactory {

	private static final Map<String, Circulo> circuloMapa = new HashMap<>();

	public static Circulo obtenerCirculo(String color) {
		// Usamos el color como clave en lugar de "key: color"
		if (!circuloMapa.containsKey(color)) {
			// Si el círculo con el color no existe, lo creamos y lo almacenamos en el mapa.
			Circulo nuevoCirculo = new Circulo(color);
			circuloMapa.put(color, nuevoCirculo);
			System.out.println("Creado un círculo de color: " + color);
		} else {
			System.out.println("Usando un círculo existente de color: " + color);
		}
		// Devolvemos el círculo desde el mapa.
		return circuloMapa.get(color);
	}
}

