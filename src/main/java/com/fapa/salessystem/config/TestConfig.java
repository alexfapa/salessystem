package com.fapa.salessystem.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fapa.salessystem.services.DBService;
import com.fapa.salessystem.services.EmailService;
import com.fapa.salessystem.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		dbService.instantiateTestDatabase();
		return true;
	}
	
	/*este @Bean faz com que ao realizar um @Autowired em algum lugar chamdo pela interface EmailSercvice seja instanciado
	 * um objeto do tipo MockEmailSercice automaticamente. FANTÁSTICO.
	 * 
	 * */
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
