package com.backend.test;

import com.backend.model.Mail;
import com.backend.service.MailService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MailServiceTest {
	private final MailService mailService = new MailService();

	@Test
	void deberiaPasarASpam() {
		//arrange
		Mail mail = new Mail("hhhhhhhjjjjj", "tttt@jjjjjjjuyg", "gggggg@colmena.com");
		String respuestaEsperada = "SPAM";
		//act
		String respuestaOptenida = mailService.procesarMail(mail);
		//assert
		assertEquals(respuestaEsperada, respuestaOptenida);
	}


}