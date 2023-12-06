package com.backend.clinicaodontologica.service;

import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.TurnoModificarEntradaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {
	TurnoSalidaDto registrarTurno(TurnoEntradaDto turno) throws BadRequestException, ResourceNotFoundException;

	List<TurnoSalidaDto> listarTurnos();

	TurnoSalidaDto modificarTurno(TurnoModificarEntradaDto turnoModificarEntradaDto) throws ResourceNotFoundException;

	TurnoSalidaDto buscarTurnoPorId(String id) throws ResourceNotFoundException;

	void eliminarTurno(String id) throws ResourceNotFoundException;
}



	