package com.backend.service;
import com.backend.handlers.*;
import com.backend.model.Mail;

public class MailService {
	private ManejadorMail primerManejador ;

	public MailService() {
		//Primer Eslabon
		primerManejador = new   ManejadorTecnico();
		//Segundo Eslabon
		ManejadorMail segundoManejador = new ManejadorComercial();
		primerManejador.setSigienteManejador(segundoManejador);
		//Tercer Eslabon
		ManejadorMail tercerManejador = new ManejadorGerencial();
		segundoManejador.setSigienteManejador(tercerManejador);
		//Cuarto Eslabon
		ManejadorMail cuartoManejador = new ManejadorSpam();
		tercerManejador.setSigienteManejador(cuartoManejador);

	}
	public  String procesarMail (Mail mail){
		return primerManejador.procesarMail(mail);
	}
}
