package com.fapa.salessystem.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.fapa.salessystem.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {

	//o valor default.sender está no arquivo aplication.properties setado com o email 
	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
		
	}

	

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! \nCódigo do pedido: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));//System.currentTimeMillis serve para garantir que será utilizada a hora do servidor
		sm.setText(obj.toString());
		
		return sm;
	}
	
	
}
