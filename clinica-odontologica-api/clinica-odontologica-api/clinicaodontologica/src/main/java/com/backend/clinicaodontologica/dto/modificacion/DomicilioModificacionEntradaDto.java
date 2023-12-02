package com.backend.clinicaodontologica.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioModificacionEntradaDto {
	@NotNull(message = "Debe proveerse el id del domicilio que se desea modificar")
	private String id;

	@NotNull(message = "El campo calle no puede ser nulo")
	@NotBlank(message = "El campo calle no puede estar en blanco")

	private String calle;

	@NotNull(message = "El campo numero no puede ser nulo")
	@Digits(integer = 8, fraction = 0, message = "El número debe tener como máximo 8 dígitos")
	private Integer numero;

	@NotNull(message = "El campo localidad no puede ser nulo")
	@NotBlank(message = "El campo localidad no puede estar en blanco")

	private String localidad;

	@NotNull(message = "El campo provincia no puede ser nulo")
	@NotBlank(message = "El campo provincia no puede estar en blanco")

	private String provincia;

	public DomicilioModificacionEntradaDto() {
	}

	public DomicilioModificacionEntradaDto(String id, String calle, Integer numero, String localidad, String provincia) {
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
}
