package com.flyweight_4.test;

import com.flyweight_4.model.Computadora;
import com.flyweight_4.service.ComputadoraFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputadoraFactoryTest {
	@Test
	public void testCrearComputadoras() {
		// Crear algunas computadoras usando la fábrica
		Computadora computadora1 = ComputadoraFactory.obtenerComputadora(4, 256);
		Computadora computadora2 = ComputadoraFactory.obtenerComputadora(8, 512);
		Computadora computadora3 = ComputadoraFactory.obtenerComputadora(4, 256);

		// Verificar que las computadoras se crearon correctamente
		assertEquals(4, computadora1.getRam());
		assertEquals(256, computadora1.getDisco());

		assertEquals(8, computadora2.getRam());
		assertEquals(512, computadora2.getDisco());

		// La tercera computadora debería ser la misma que la primera
		assertEquals(computadora1, computadora3);
	}

}