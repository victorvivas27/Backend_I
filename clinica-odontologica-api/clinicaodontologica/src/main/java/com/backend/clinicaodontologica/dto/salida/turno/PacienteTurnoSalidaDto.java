package com.backend.clinicaodontologica.dto.salida.turno;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIgnoreProperties: Esta anotación se coloca a nivel de clase y
// se utiliza para especificar propiedades que deben ser ignoradas
// durante la serialización o deserialización. ignoreUnknown = true
// es un parámetro que indica que cualquier propiedad desconocida
// en el JSON debe ser ignorada durante la deserialización.
public class PacienteTurnoSalidaDto {
	private String id;
	private String nombre;
	private String apellido;

	public PacienteTurnoSalidaDto() {
	}

	public PacienteTurnoSalidaDto(String id, String nombre, String apellido) {
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
