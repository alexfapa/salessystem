package com.example.salessystem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.salessystem.domain.Categoria;
import com.example.salessystem.domain.Produto;
import com.example.salessystem.repositories.CategoriaRepository;
import com.example.salessystem.repositories.ProdutoRepository;

@SpringBootApplication
public class SalesSystemApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository repo;
	
	@Autowired
	ProdutoRepository prod;
	
	public static void main(String[] args) {
		SpringApplication.run(SalesSystemApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Telefonia");
		Categoria cat4 = new Categoria(null, "Acessórios");
		Categoria cat5 = new Categoria(null, "Cozinha");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		Produto p4 = new Produto(null, "Celular", 1080.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p4));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat3));
		
		repo.saveAll(Arrays.asList(cat2, cat1, cat3, cat4, cat5));
		prod.saveAll(Arrays.asList(p1, p2, p3, p4));
		
	}

}
