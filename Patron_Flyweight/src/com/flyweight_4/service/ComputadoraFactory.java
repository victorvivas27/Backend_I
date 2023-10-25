package com.flyweight_4.service;

import com.flyweight_4.model.Computadora;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
	// Mapa para almacenar instancias de Computadora
	private static Map<String, Computadora> computadoraMap = new HashMap<>();

	// Método para obtener una instancia de Computadora basada en RAM y disco
	public static Computadora obtenerComputadora(int ram, int disco) {
		// Crear una clave basada en las características de RAM y disco
		String key = "key: " + ram + "-" + disco;

		// Verificar si ya existe una instancia con esta clave
		if (!computadoraMap.containsKey(key)) {
			// Si no existe, crear una nueva instancia de Computadora
			Computadora nuevaComputadora = new Computadora(ram, disco);
			// Agregar la nueva instancia al mapa
			computadoraMap.put(key, nuevaComputadora);
			System.out.println("Computadora creada");
		} else {
			// Si ya existe una instancia con la misma clave, no crear una nueva
			System.out.println("Computadora encontrada");
		}

		// Devolver la instancia de Computadora correspondiente a la clave
		return computadoraMap.get(key);
	}
}