package com.backend.handlers;

import com.backend.model.Mail;

public class ManejadorComercial extends ManejadorMail {
	@Override
	public String procesarMail(Mail mail) {
		System.out.println("Area Comercial  trabajando ......");
		String respuesta = "";
		if (mail.getAsunto().equalsIgnoreCase("comercial") || mail.getDestino().equals("comercial@colmena.com")) {
			respuesta = "Area Comercial  procesando mail...";
		} else respuesta = getSigienteManejador().procesarMail(mail);
		return respuesta;
	}
}
