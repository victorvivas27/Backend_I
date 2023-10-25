package com.flyweight_1.service;

import com.flyweight_1.model.Cancion;
import java.util.HashMap;
import java.util.Map;

public class CancionFactory {
	// Usamos un mapa para almacenar las canciones existentes y sus claves únicas.
	private static final Map<String, Cancion> cancionesMap = new HashMap<>();

	// Este método se encarga de obtener una canción o crear una nueva si no existe.
	public static Cancion obtenerCancion(String nombre, String artista, String genero) {
		// Creamos una clave única para la canción basada en su nombre, artista y género.
		String clave = "clave: " + nombre + " - " + artista + " - " + genero;

		// Verificamos si la canción ya existe en el mapa.
		if (!cancionesMap.containsKey(clave)) {
			// Si no existe, creamos una nueva canción.
			Cancion nuevaCancion = new Cancion(nombre, artista, genero);

			// Almacenamos la nueva canción en el mapa utilizando su clave única.
			cancionesMap.put(clave, nuevaCancion);
		} else {
			// Si la canción ya existe, imprimimos un mensaje.
			System.out.println("Canción creada");
		}

		// Devolvemos la canción, ya sea la recién creada o la existente en el mapa.
		return cancionesMap.get(clave);
	}
}