package com.fapa.salessystem.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.fapa.salessystem.domain.Categoria;
import com.fapa.salessystem.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	/*
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> search(@Param("nome") String nome, @Param("categorias")List<Categoria> categorias, Pageable pageRequest);
	*/
	
	/*Fazendo da forma abaixo, a mesma consulta de cima é feita, porém com o padrão de nomes do SpringData
	 * Colocando a @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias") abaixo, o SpringData
	 * da prioridade à query, porém, neste caso somente o médoto com a nomenclatura padrão é capaz de fazer o que a @Query faz
	 * */
	@Transactional(readOnly = true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}
