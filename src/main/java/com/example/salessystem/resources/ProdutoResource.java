package com.example.salessystem.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.salessystem.domain.Produto;
import com.example.salessystem.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	ProdutoService service;
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> findProduto(@PathVariable Integer id){
		Produto obj = service.buscarProdutoId(id);
		return ResponseEntity.ok().body(obj);
	}
}
