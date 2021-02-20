package com.fapa.salessystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fapa.salessystem.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
