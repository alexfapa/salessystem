package com.example.salessystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.salessystem.domain.Pedido;
import com.example.salessystem.repositories.PedidoRepository;
import com.example.salessystem.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: "+ Pedido.class.getName()));
	}
	
}
