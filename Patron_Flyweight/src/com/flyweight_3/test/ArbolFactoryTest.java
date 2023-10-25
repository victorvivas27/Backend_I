package com.flyweight_3.test;

import com.flyweight_3.model.Arbol;
import com.flyweight_3.service.ArbolFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolFactoryTest {
	@Test
	public void testObtenerArbolNuevo() {

		// Obtener un nuevo árbol
		Arbol arbol1 = ArbolFactory.optenerArbol(10, 20, "Verde", "Pino");

		// Verificar que se crea un árbol nuevo
		assertEquals(10, arbol1.getAlto());
		assertEquals(20, arbol1.getAncho());
		assertEquals("Pino", arbol1.getTipo());
		assertEquals("Verde", arbol1.getColor());
	}

	@Test
	public void testObtenerArbolExistente() {
		ArbolFactory arbolFactory = new ArbolFactory();

		// Obtener un árbol con las mismas características dos veces
		Arbol arbol1 = ArbolFactory.optenerArbol(5, 10, "Roble", "Marrón");
		Arbol arbol2 = ArbolFactory.optenerArbol(5, 10, "Roble", "Marrón");

		// Verificar que se devuelve el mismo árbol
		assertSame(arbol1, arbol2);
	}

	@Test
	public void testObtenerArbolesDiferentes() {
		ArbolFactory arbolFactory = new ArbolFactory();

		// Obtener árboles con diferentes características
		Arbol arbol1 = ArbolFactory.optenerArbol(8, 15, "Cerezo", "Rosa");
		Arbol arbol2 = ArbolFactory.optenerArbol(6, 12, "Pino", "Verde");

		// Verificar que los árboles son diferentes
		assertNotSame(arbol1, arbol2);
	}

}