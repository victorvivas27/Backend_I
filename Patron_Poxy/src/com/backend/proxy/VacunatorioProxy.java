package com.backend.proxy;

import com.backend.clase.model.Persona;

import java.time.LocalDate;

public class VacunatorioProxy implements Vacunatorio {
	private VacunatorioService vacunatorioService;

	@Override
	public String vacunar(Persona persona) {
		String respueta = "La fecha no se corresponde con la fecha asignada";
		if (validarFecha(persona.getFechaAsignada())) {
			vacunatorioService = new VacunatorioService();
			respueta = vacunatorioService.vacunar(persona);
		}
		return respueta;
	}

	private boolean validarFecha(LocalDate fecha) {
		LocalDate ahora = LocalDate.now();
		return !ahora.isBefore(fecha);
	}

}
