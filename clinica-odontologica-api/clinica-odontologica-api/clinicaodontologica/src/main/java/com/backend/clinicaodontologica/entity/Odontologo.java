package com.backend.clinicaodontologica.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "odontologos")
public class Odontologo {
	@Id
	private String id;

	private String matricula;

	private String nombre;

	private String apellido;

	public Odontologo() {
	}

	public Odontologo(String id, String matricula, String nombre, String apellido) {
		this.id = id;
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
}
