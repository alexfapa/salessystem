package com.example.salessystem;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.salessystem.domain.Categoria;
import com.example.salessystem.repositories.CategoriaRepository;

@SpringBootApplication
public class SalesSystemApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SalesSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Telefonia");
		Categoria cat4 = new Categoria(null, "Acessórios");
		Categoria cat5 = new Categoria(null, "Cozinha");
		
		repo.saveAll(Arrays.asList(cat2, cat1, cat3, cat4, cat5));
	}

}
