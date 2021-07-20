package com.fapa.salessystem;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fapa.salessystem.services.S3Service;

@SpringBootApplication
public class SalesSystemApplication implements CommandLineRunner{
	
	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(SalesSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws ParseException {
		s3Service.uploadFile("C:\\Users\\francisco.alex\\Pictures\\Photos\\DudaRanataEu.jpg");						
	}

}
