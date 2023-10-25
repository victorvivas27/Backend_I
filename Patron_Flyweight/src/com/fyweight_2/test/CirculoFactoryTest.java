package com.fyweight_2.test;

import com.fyweight_2.model.Circulo;
import com.fyweight_2.service.CirculoFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirculoFactoryTest {
	@Test
	public void testOptenerCirculo() {
		// Crear un objeto Circulo usando la fábrica
		Circulo circulo1 = CirculoFactory.obtenerCirculo("Rojo");
		Circulo circulo2 = CirculoFactory.obtenerCirculo("Azul");

		// Verificar que se crean objetos Circulo únicos para diferentes colores
		assertEquals("Rojo", circulo1.getColor());
		assertEquals("Azul", circulo2.getColor());
	}
	@Test
	public void testOptenerCirculoReutilizacion() {
		// Intentar obtener un círculo que ya ha sido creado previamente
		Circulo circulo1 =  CirculoFactory.obtenerCirculo("Rojo");
		Circulo circulo2 = CirculoFactory.obtenerCirculo("Rojo");

		// Verificar que se devuelve el mismo objeto para el mismo color
		assertEquals(circulo1, circulo2);
	}
	@Test
	public void testOptenerCirculosVariosColores() {
		// Crear objetos Circulo con diferentes colores
		Circulo circuloRojo = CirculoFactory.obtenerCirculo("Rojo");
		Circulo circuloAzul =  CirculoFactory.obtenerCirculo("Azul");
		Circulo circuloVerde = CirculoFactory.obtenerCirculo("Verde");

		// Verificar que los colores son correctos
		assertEquals("Rojo", circuloRojo.getColor());
		assertEquals("Azul", circuloAzul.getColor());
		assertEquals("Verde", circuloVerde.getColor());

		// Verificar que los objetos Circulo son únicos para cada color
		assertNotEquals(circuloRojo, circuloAzul);
		assertNotEquals(circuloRojo, circuloVerde);
		assertNotEquals(circuloAzul, circuloVerde);
	}

}