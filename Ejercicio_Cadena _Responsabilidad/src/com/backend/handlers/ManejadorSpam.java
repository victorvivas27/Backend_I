package com.backend.handlers;

import com.backend.model.Mail;

public class ManejadorSpam  extends  ManejadorMail{
	@Override
	public String procesarMail(Mail mail) {
		System.out.println("Spameando");
		return "SPAM";
	}
}
