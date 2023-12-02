package com.backend.clinicaodontologica.service;


import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
	PacienteSalidaDto registrarPaciente(PacienteEntradaDto pacienteEntradaDto);

	List<PacienteSalidaDto> listarPacientes();

	PacienteSalidaDto buscarPacientePorId(String id) throws ResourceNotFoundException;

	PacienteSalidaDto actualizarPaciente(PacienteModificacionEntradaDto pacienteModi) throws ResourceNotFoundException;


	void eliminarPaciente(String id) throws ResourceNotFoundException;


}
