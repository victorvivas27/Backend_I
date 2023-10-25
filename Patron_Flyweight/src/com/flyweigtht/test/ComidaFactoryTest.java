package com.flyweigtht.test;

import com.flyweigtht.model.Comida;
import com.flyweigtht.service.ComidaFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComidaFactoryTest {
	@Test
	public void testGetComida() {
		Comida comida1 = ComidaFactory.optenerComida("Hamburguesa");
		Comida comida2 = ComidaFactory.optenerComida("Hamburguesa");

		// Verifica que se devuelva la misma instancia de Comida
		assertSame(comida1, comida2);
	}

	// Agrega más pruebas según sea necesario

}