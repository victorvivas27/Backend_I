package com.backend.handlers;

import com.backend.model.Mail;

public class ManejadorGerencial extends ManejadorMail {

	@Override
	public String procesarMail(Mail mail) {
		System.out.println(" Area Gerencial trabajando ......");
		String respuesta = "";
		if (mail.getAsunto().equalsIgnoreCase("gerencia") || mail.getDestino().equals("gerencia@colmena.com")) {
			respuesta = " Area Gerencial procesando mail...";
		} else respuesta = getSigienteManejador().procesarMail(mail);
		return respuesta;
	}
}
