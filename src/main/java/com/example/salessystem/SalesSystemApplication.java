package com.example.salessystem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.salessystem.domain.Categoria;
import com.example.salessystem.domain.Cidade;
import com.example.salessystem.domain.Cliente;
import com.example.salessystem.domain.Endereco;
import com.example.salessystem.domain.Estado;
import com.example.salessystem.domain.Produto;
import com.example.salessystem.domain.enums.TipoCliente;
import com.example.salessystem.repositories.CategoriaRepository;
import com.example.salessystem.repositories.CidadeRepository;
import com.example.salessystem.repositories.ClienteRepository;
import com.example.salessystem.repositories.EnderecoRepository;
import com.example.salessystem.repositories.EstadoRepository;
import com.example.salessystem.repositories.ProdutoRepository;

@SpringBootApplication
public class SalesSystemApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository repo;
	
	@Autowired
	ProdutoRepository prod;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo"); 
		
		Cidade c1 = new Cidade(null, "Uberlândoa", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto. 20", "Jardim", "38228024", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "3877712", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
						
	}

}
