package com.example.salessystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.salessystem.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
