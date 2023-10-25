package com.flyweight_3.service;

import com.flyweight_3.model.Arbol;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
	private static Map<String, Arbol> arbolMap = new HashMap<>();

	public static Arbol optenerArbol(int alto, int ancho, String color, String tipo) {
		String key = "key : " + alto + "-" + ancho + "-" + color + "-" + tipo;
		if (!arbolMap.containsKey(key)) {
			Arbol nuevoArbol = new Arbol(alto, ancho, color, tipo);
			arbolMap.put(key, nuevoArbol);
		} else {
			System.out.println("Nuevo Arbol creado ");
		}
		return arbolMap.get(key);
	}
}









