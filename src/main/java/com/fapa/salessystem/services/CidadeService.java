package com.fapa.salessystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fapa.salessystem.domain.Cidade;
import com.fapa.salessystem.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cr;
	
	public List<Cidade> findAllByEstado(Integer id){
		return cr.findAllByEstado(id);
	}
}
