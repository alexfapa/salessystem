package com.example.salessystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.salessystem.domain.Cliente;
import com.example.salessystem.repositories.ClienteRepository;
import com.example.salessystem.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: "+ Cliente.class.getName()));
	}
	
}