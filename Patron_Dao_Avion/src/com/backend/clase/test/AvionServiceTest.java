package com.backend.clase.test;

import com.backend.clase.dao.implementacion.AvionDaoH2;
import com.backend.clase.model.Avion;
import com.backend.clase.sevice.AvionService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AvionServiceTest {
	private AvionService avionService;

	@Test
	public void deberiaAgregarYRetornarUnAvion() {
		avionService = new AvionService(new AvionDaoH2());
		Avion avion = new Avion("Pelicano", "Tres plazas x456", "A788HY", LocalDate.of(2023, 10, 26));
		Avion avionPersistido = avionService.registrarAvion(avion);
		assertNotNull(avionPersistido.getId());
	}
}