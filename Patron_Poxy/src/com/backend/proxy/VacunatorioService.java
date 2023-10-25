package com.backend.proxy;

import com.backend.clase.model.Persona;

import java.time.LocalDate;

public class VacunatorioService implements Vacunatorio {
	@Override
	public String vacunar(Persona persona) {
		System.out.println("Recibiendo a  " + persona.getNombre() + " .......");
		return "Se ha registrado a la persona con DNI " + persona.getDni()
				+ ",fue vacunado el dia  " + LocalDate.now() + "  con la vacuna  " + persona.getNombreVacuna();


	}

}
