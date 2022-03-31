package com.fapa.salessystem.services;

import com.fapa.salessystem.domain.Cliente;
import com.fapa.salessystem.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;



public interface EmailService {
	
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
