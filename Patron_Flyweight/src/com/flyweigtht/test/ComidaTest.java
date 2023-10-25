package com.flyweigtht.test;

import com.flyweigtht.model.Comida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComidaTest {
	private Comida comida;
	@BeforeEach
	public void setUp() {
		comida = new Comida("Hamburguesa");
	}

	@Test
	public void testGetTipoComida() {
		assertEquals("Hamburguesa", comida.getTipoComida());
	}

	@Test
	public void testSetPrecio() {
		comida.setPrecio(10);
		assertEquals(10, comida.getPrecio());
	}

	// Agrega más pruebas según sea necesario

}