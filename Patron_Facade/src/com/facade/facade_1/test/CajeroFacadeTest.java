package com.facade_1.test;

import com.facade_1.service.CajeroFacade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CajeroFacadeTest {
	@Test
	public void testRetirarDineroExitoso() {
		CajeroFacade cajero = new CajeroFacade();

		// Proporciona datos de prueba
		String dni = "123456789";
		String contrasena = "mypassword";
		double montoARetirar = 200.0;

		// Realiza el retiro de dinero
		boolean retiroExitoso = cajero.retirarDinero(dni, contrasena, montoARetirar);

		// Verifica si el retiro fue exitoso
		assertTrue(retiroExitoso);
	}

	@Test
	public void testRetirarDineroFallido() {
		CajeroFacade cajero = new CajeroFacade();

		// Proporciona datos de prueba (contraseña incorrecta)
		String dni = "123456789";
		String contrasena = "incorrectpassword";
		double montoARetirar = 0.0;

		// Realiza el retiro de dinero
		boolean retiroExitoso = cajero.retirarDinero(dni, contrasena, montoARetirar);

		// Verifica si el retiro falló (la contraseña es incorrecta)
		assertFalse(retiroExitoso);
	}
}