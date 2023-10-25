package com.backend.test;
import com.backend.clase.model.Persona;
import com.backend.proxy.Vacunatorio;
import com.backend.proxy.VacunatorioProxy;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VacunatorioProxyTest {
	private Vacunatorio vacunatorio = new VacunatorioProxy();
	@Test
	void siLaPersonaConcurreAntesDeSuFechaAsignada_noDeberiaVacunarseALaPersona(){
		//arrange
		Persona persona = new Persona("Victor Vivas","27986534",
				LocalDate.of(2023,10,15),"AntiGripal");
		String respuestaEsperada = "La fecha no se corresponde con la fecha asignada";
		//act
		String respuestaObtenida = vacunatorio.vacunar(persona);
		//assert
		assertEquals(respuestaEsperada,respuestaObtenida);
	}
	@Test
	void siLaPersonaConcurreEnLaFechaAsignada_deberiaVacunarseExitosamente() {
		// Arrange
		Persona persona = new Persona("Ana Lopez", "12345678",
				LocalDate.of(2023,10,10), "AntiGripal");
		String respuestaEsperada = "Se ha registrado a la persona con DNI 12345678,fue vacunado el dia  2023-10-10  con la vacuna  AntiGripal";
		// Act
		String respuestaObtenida = vacunatorio.vacunar(persona);
		// Assert
		assertEquals(respuestaEsperada, respuestaObtenida);
	}

}