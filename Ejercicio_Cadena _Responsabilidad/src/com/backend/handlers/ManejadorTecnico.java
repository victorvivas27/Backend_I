package com.backend.handlers;

import com.backend.model.Mail;

public class ManejadorTecnico extends ManejadorMail {
	@Override
	public String procesarMail(Mail mail) {
		System.out.println(" Area Tecnica  trabajando ......");
		String respuesta = "";
		if (mail.getAsunto().equalsIgnoreCase("tecnica") || mail.getDestino().equals("tenica@colmena.com")) {
			respuesta = " Area Tecnica  procesando mail...";
		} else respuesta = getSigienteManejador().procesarMail(mail);
		return respuesta;
	}
}
