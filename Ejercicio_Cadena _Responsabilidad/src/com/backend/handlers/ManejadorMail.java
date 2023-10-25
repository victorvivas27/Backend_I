package com.backend.handlers;


import com.backend.model.Mail;

public abstract class ManejadorMail {
	private ManejadorMail sigienteManejador;

	public ManejadorMail getSigienteManejador() {
		return sigienteManejador;
	}

	public void setSigienteManejador(ManejadorMail sigienteManejador) {
		this.sigienteManejador = sigienteManejador;
	}

	public abstract String procesarMail(Mail mail);
}
