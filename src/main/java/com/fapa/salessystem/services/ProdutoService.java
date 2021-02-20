package com.fapa.salessystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fapa.salessystem.domain.Produto;
import com.fapa.salessystem.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo;
	
	public Produto buscarProdutoId(Integer id){
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
