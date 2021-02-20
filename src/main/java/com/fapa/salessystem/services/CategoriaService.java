package com.fapa.salessystem.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fapa.salessystem.domain.Categoria;
import com.fapa.salessystem.repositories.CategoriaRepository;
import com.fapa.salessystem.services.exceptions.DataIntegrityException;
import com.fapa.salessystem.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: "+ Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return obj = repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return obj = repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) { 
			/*
			 * para esta excessão deve ser implementado para o resource no arquivo
			 * ResouceExceptionHandler no pacote service.excptions
			 * */ 
			throw new DataIntegrityException("Não foi é possível excluir Categorias com Produtos associados!");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
}
