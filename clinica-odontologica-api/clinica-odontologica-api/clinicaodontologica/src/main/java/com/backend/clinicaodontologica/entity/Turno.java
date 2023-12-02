package com.backend.clinicaodontologica.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "turnos")
public class Turno {
	@Id
	private String id;
	private LocalDateTime fechaYHora;
	@DBRef
	private Odontologo odontologo;
	@DBRef
	private Paciente paciente;

	public Turno() {
	}

	public Turno(String id, LocalDateTime fechaYHora, Odontologo odontologo, Paciente paciente) {
		this.id = id;
		this.fechaYHora = fechaYHora;
		this.odontologo = odontologo;
		this.paciente = paciente;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public Odontologo getOdontologo() {
		return odontologo;
	}

	public void setOdontologo(Odontologo odontologo) {
		this.odontologo = odontologo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
