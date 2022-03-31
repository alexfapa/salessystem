package com.fapa.salessystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fapa.salessystem.domain.Estado;
import com.fapa.salessystem.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository er;
	
	public List<Estado> findAll(){				
		return er.findAllByOrderByNome();
	}
}
