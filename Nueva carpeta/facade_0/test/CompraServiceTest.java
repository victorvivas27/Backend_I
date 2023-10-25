package com.facade.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CompraServiceTest {
	@Test
	public void testProcesarCompra() {
		// Crear objetos reales para la prueba
		List<Producto> productos = new ArrayList<>();
		productos.add(new Producto("P1", "ProductoSuper 1", 10.0, 5));

		Tarjeta tarjeta = new Tarjeta("1234567890123456", "123");
		Direccion direccion = new Direccion("Calle Ejemplo", "123", "Barrio Ejemplo");

		CompraService compraService = new CompraService(); // Usar implementaciones reales

		// Realizar la prueba
		compraService.procesarCompra("P1", 3, tarjeta, direccion, productos);

		// Verificar resultados si es necesario
		// Puedes usar aserciones (assertions) para verificar resultados si es necesario.
	}

}