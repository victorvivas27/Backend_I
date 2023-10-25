package com.flyweigtht.service;

import com.flyweigtht.model.Comida;

import java.util.HashMap;
import java.util.Map;

public class ComidaFactory {
	// HashMap para almacenar objetos Comida compartidos
	private static final Map<String, Comida> comidaMap = new HashMap();

	// Método para obtener una instancia de Comida
	public static Comida optenerComida(String tipoComida) {
		Comida comida = comidaMap.get(tipoComida);

		// Si no existe una instancia previa, crea una nueva
		if (comida == null) {
			comida = new Comida(tipoComida);
			comidaMap.put(tipoComida, comida);
			System.out.println("Creando objeto comida de tipo: " + tipoComida);
		}

		return comida;
	}
}