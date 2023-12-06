package com.backend.clinicaodontologica.dto.salida.turno;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class OdontologoTurnoSalidaDto {
	private String id;
	private String nombre;
	private String apellido;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public OdontologoTurnoSalidaDto() {
	}

	public OdontologoTurnoSalidaDto(String id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
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

	@Override
	public String toString() {
		return "Id: " + id + " - Nombre: " + nombre + " - Apellido: " + apellido;
	}
}
