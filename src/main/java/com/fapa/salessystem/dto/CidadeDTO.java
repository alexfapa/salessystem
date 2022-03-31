package com.fapa.salessystem.dto;

import java.io.Serializable;

import com.fapa.salessystem.domain.Cidade;

public class CidadeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String nome;
	
	public CidadeDTO() {
		
	}
	
	public CidadeDTO(Cidade obj) {
		super();
		this.id = obj.getId();
		this.setNome(obj.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
