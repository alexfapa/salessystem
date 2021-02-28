package com.fapa.salessystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fapa.salessystem.domain.Categoria;
import com.fapa.salessystem.domain.Produto;
import com.fapa.salessystem.repositories.CategoriaRepository;
import com.fapa.salessystem.repositories.ProdutoRepository;
import com.fapa.salessystem.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Produto buscarProdutoId(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: "+ Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		//return repo.search(nome, categorias, pageRequest);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}
