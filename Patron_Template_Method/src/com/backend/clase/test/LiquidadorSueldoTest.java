package com.backend.clase.test;
import com.backend.clase.model.Empleado;
import com.backend.clase.model.EmpleadoEfectivo;
import com.backend.clase.service.LiquidadorEfectivo;
import com.backend.clase.service.LiquidadorSueldo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LiquidadorSueldoTest {
	private LiquidadorSueldo liquidadorSueldo;

	@Test
	void unliquidadorEfectivo_deberiaCalcularleElSueldoAUnEmpleadoEfectivo() {
		//arrange
		Empleado empleado = new EmpleadoEfectivo("Victor", "Vivas", "778383883747", 1000000, 6000, 25000);
		liquidadorSueldo = new LiquidadorEfectivo();
		//act
		String resultadoEsperado = "Recibo genearado en forma digital. Sueldo a liquidar $ 981000.0";
		String resultadoObtenido = liquidadorSueldo.liquidarSueldo(empleado);
		//assert
		assertEquals(resultadoEsperado, resultadoObtenido);

	}
}

