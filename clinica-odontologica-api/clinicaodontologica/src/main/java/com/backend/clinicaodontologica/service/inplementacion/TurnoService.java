package com.backend.clinicaodontologica.service.inplementacion;

import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.TurnoModificarEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.OdontologoTurnoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.PacienteTurnoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.entity.Turno;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaodontologica.repository.TurnoRepository;
import com.backend.clinicaodontologica.service.ITurnoService;
import com.backend.clinicaodontologica.util.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {
	private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);

	private final TurnoRepository turnoRepository;

	private final ModelMapper modelMapper;
	private final PacienteService pacienteService;
	private final OdontologoService odontologoService;

	public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper, PacienteService pacienteService, OdontologoService odontologoService) {
		this.turnoRepository = turnoRepository;
		this.modelMapper = modelMapper;
		this.pacienteService = pacienteService;
		this.odontologoService = odontologoService;

	}


	@Override
	public List<TurnoSalidaDto> listarTurnos() {
		List<Turno> turnos = turnoRepository.findAll();
		List<TurnoSalidaDto> turnoSalidaDtos = new ArrayList<>();

		for (Turno turno : turnos) {
			try {
				TurnoSalidaDto turnoSalidaDto = entidadADto(turno);
				turnoSalidaDtos.add(turnoSalidaDto);
			} catch (ResourceNotFoundException e) {
				// Manejar la excepción si es necesario
				LOGGER.error("Error al convertir turno a DTO: {}", e.getMessage());
			}
		}

		LOGGER.info("Listando de todos los turnos: {}", JsonPrinter.toString(turnoSalidaDtos));
		return turnoSalidaDtos;
	}

	@Override
	public TurnoSalidaDto registrarTurno(TurnoEntradaDto turno) throws BadRequestException, ResourceNotFoundException {
		TurnoSalidaDto turnoSalidaDto;

		PacienteSalidaDto paciente = pacienteService.buscarPacientePorId(turno.getPaciente().getId());
		OdontologoSalidaDto odontologo = odontologoService.buscarOdontologoPorId(turno.getOdontologo().getId());

		String pacienteNoEnBdd = "El paciente no se encuentra en nuestra base de datos";
		String odontologoNoEnBdd = "El odontologo no se encuentra en nuestra base de datos";

		if (paciente == null || odontologo == null) {
			if (paciente == null && odontologo == null) {
				LOGGER.error("El paciente y el odontologo no se encuentran en nuestra base de datos");
				throw new BadRequestException("El paciente y el odontologo no se encuentran en nuestra base de datos");
			} else if (paciente == null) {
				LOGGER.error(pacienteNoEnBdd);
				throw new BadRequestException(pacienteNoEnBdd);
			} else {
				LOGGER.error(odontologoNoEnBdd);
				throw new BadRequestException(odontologoNoEnBdd);
			}
		} else {

			Turno turnoNuevo = turnoRepository.save(modelMapper.map(turno, Turno.class));
			turnoSalidaDto = entidadADto(turnoNuevo);

			LOGGER.info("Nuevo turno registrado con exito: {}", turnoSalidaDto);
		}

		return turnoSalidaDto;
	}


	@Override
	public TurnoSalidaDto buscarTurnoPorId(String id) throws ResourceNotFoundException {
		Turno turnoBuscado = turnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id no encontrado en base de datos"));

		TurnoSalidaDto turnoEncontrado = modelMapper.map(turnoBuscado, TurnoSalidaDto.class);

		if (turnoBuscado.getPaciente() != null) {
			turnoEncontrado.setPacienteTurnoSalidaDto(pacienteSalidaDtoASalidaTurnoDto(turnoBuscado.getPaciente().getId()));
		}

		if (turnoBuscado.getOdontologo() != null) {
			turnoEncontrado.setOdontologoTurnoSalidaDto(odontologoSalidaDtoASalidaTurnoDto(turnoBuscado.getOdontologo().getId()));
		}

		LOGGER.info("Turno encontrado: {}", JsonPrinter.toString(turnoEncontrado));

		return turnoEncontrado;
	}

	@Override
	public TurnoSalidaDto modificarTurno(TurnoModificarEntradaDto turnoModificacionDto) throws ResourceNotFoundException {
		// Obtener el turno actualizado desde el repositorio
		Turno turnoAActualizar = turnoRepository.findById(turnoModificacionDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado en la base de datos"));

		// Actualizar las propiedades modificables del turno
		// Por ejemplo, si solo puedes actualizar la fecha y hora, puedes hacer lo siguiente:
		turnoAActualizar.setFechaYHora(turnoModificacionDto.getFechaYHora());

		// Guardar el turno actualizado en el repositorio
		Turno turnoActualizado = turnoRepository.save(turnoAActualizar);

		// Mapear el turno actualizado a un DTO de salida
		TurnoSalidaDto turnoSalidaDto = modelMapper.map(turnoActualizado, TurnoSalidaDto.class);

		LOGGER.warn("Turno actualizado: {}", JsonPrinter.toString(turnoSalidaDto));

		return turnoSalidaDto;
	}


	@Override
	public void eliminarTurno(String id) throws ResourceNotFoundException {
		if (turnoRepository.findById(id).orElse(null) != null) {
			turnoRepository.deleteById(id);
			LOGGER.warn("Se eliminoe el turno con id:{}", id);
		} else {
			LOGGER.error("No se ha encontrado el paciente con id:{}", id);
			throw new ResourceNotFoundException("No se ha encontrado el turno con id " + id);
		}

	}

	private PacienteTurnoSalidaDto pacienteSalidaDtoASalidaTurnoDto(String id) throws ResourceNotFoundException {
		return modelMapper.map(pacienteService.buscarPacientePorId(id), PacienteTurnoSalidaDto.class);
	}

	private OdontologoTurnoSalidaDto odontologoSalidaDtoASalidaTurnoDto(String id) throws ResourceNotFoundException {
		return modelMapper.map(odontologoService.buscarOdontologoPorId(id), OdontologoTurnoSalidaDto.class);
	}

	private TurnoSalidaDto entidadADto(Turno turno) throws ResourceNotFoundException {
		TurnoSalidaDto turnoSalidaDto = modelMapper.map(turno, TurnoSalidaDto.class);
		turnoSalidaDto.setPacienteTurnoSalidaDto(pacienteSalidaDtoASalidaTurnoDto(turno.getPaciente().getId()));
		turnoSalidaDto.setOdontologoTurnoSalidaDto(odontologoSalidaDtoASalidaTurnoDto(turno.getOdontologo().getId()));
		return turnoSalidaDto;
	}
}


