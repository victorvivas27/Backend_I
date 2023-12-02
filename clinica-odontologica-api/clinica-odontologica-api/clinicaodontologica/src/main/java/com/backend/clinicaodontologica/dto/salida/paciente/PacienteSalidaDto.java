package com.backend.clinicaodontologica.dto.salida.paciente;

import java.time.LocalDate;

public class PacienteSalidaDto {
	private String id;
	private String nombre;
	private String apellido;
	private Long dni;
	private LocalDate fechaIngreso;
	private DomicilioSalidaDto domicilio;

	public PacienteSalidaDto() {
	}

	public PacienteSalidaDto(String id, String nombre, String apellido, Long dni,
							 LocalDate fechaIngreso, DomicilioSalidaDto domicilio) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaIngreso = fechaIngreso;
		this.domicilio = domicilio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public DomicilioSalidaDto getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioSalidaDto domicilio) {
		this.domicilio = domicilio;
	}
}
