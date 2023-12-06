package com.backend.clinicaodontologica.controller;

import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.TurnoModificarEntradaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaodontologica.service.ITurnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {
	private final ITurnoService iTurnoService;

	public TurnoController(ITurnoService iTurnoService) {
		this.iTurnoService = iTurnoService;
	}


	// POST - Crear un nuevo turno
	@Operation(summary = "Registrar un nuevo turno")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Turno registrado correctamente",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = TurnoSalidaDto.class))}),
			@ApiResponse(responseCode = "400", description = "Bad Request",
					content = @Content),
			@ApiResponse(responseCode = "404", description = "Not Found",
					content = @Content),
			@ApiResponse(responseCode = "500", description = "Server Error",
					content = @Content)
	})
	@PostMapping("/registrar")
	private ResponseEntity<TurnoSalidaDto> registrarTurno(@Valid @RequestBody TurnoEntradaDto turno)
			throws BadRequestException, ResourceNotFoundException {
		return new ResponseEntity<>(iTurnoService.registrarTurno(turno), HttpStatus.CREATED);
	}

	// GET - Listar todos los turnos
	@Operation(summary = "Listar todos los turnos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Listado de turnos obtenido correctamente",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = TurnoSalidaDto.class))}),
			@ApiResponse(responseCode = "500", description = "Server Error",
					content = @Content)
	})
	@GetMapping("/listar")
	public ResponseEntity<List<TurnoSalidaDto>> listarTurnos() {
		return new ResponseEntity<>(iTurnoService.listarTurnos(), HttpStatus.OK);
	}

	// GET - Buscar un turno por ID
	@Operation(summary = "Buscar un turno por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Turno obtenido correctamente",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = TurnoSalidaDto.class))}),
			@ApiResponse(responseCode = "404", description = "Turno no encontrado",
					content = @Content),
			@ApiResponse(responseCode = "500", description = "Server Error",
					content = @Content)
	})
	@GetMapping("/{id}")
	public ResponseEntity<TurnoSalidaDto> buscarTurnoPorId(
			@Parameter(description = "ID del turno a buscar", required = true)
			@PathVariable String id) throws ResourceNotFoundException {
		return new ResponseEntity<>(iTurnoService.buscarTurnoPorId(id), HttpStatus.OK);
	}

	//PUT Actualizar turno por su ID
	@Operation(summary = "Actualizar un turno")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Turno actualizado correctamente",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = TurnoSalidaDto.class))}),
			@ApiResponse(responseCode = "400", description = "Bad Request",
					content = @Content),
			@ApiResponse(responseCode = "404", description = "Turno no encontrado",
					content = @Content),
			@ApiResponse(responseCode = "500", description = "Server Error",
					content = @Content)
	})
	@PutMapping("/actualizar")
	public ResponseEntity<TurnoSalidaDto> actualizarTurno(
			@Parameter(description = "Datos actualizados del turno", required = true)
			@Valid @RequestBody TurnoModificarEntradaDto turno) throws ResourceNotFoundException {
		return new ResponseEntity<>(iTurnoService.modificarTurno(turno), HttpStatus.OK);
	}

	//DELET Eliminar turno por su ID
	@Operation(summary = "Eliminar un turno por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Turno eliminado correctamente",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = String.class))}),
			@ApiResponse(responseCode = "404", description = "Turno no encontrado",
					content = @Content),
			@ApiResponse(responseCode = "500", description = "Server Error",
					content = @Content)
	})
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminarTurno(
			@Parameter(description = "ID del turno a eliminar", required = true)
			@PathVariable String id) throws ResourceNotFoundException {
		iTurnoService.eliminarTurno(id);
		return new ResponseEntity<>("Turno eliminado correctamente", HttpStatus.OK);
	}
}
