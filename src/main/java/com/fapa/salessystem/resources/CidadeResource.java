package com.fapa.salessystem.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fapa.salessystem.domain.Cidade;
import com.fapa.salessystem.dto.CidadeDTO;
import com.fapa.salessystem.services.CidadeService;

@RestController
@RequestMapping(value="/estados")
public class CidadeResource {

	
	@Autowired
	private CidadeService cs;
	
	
	@RequestMapping(value="/{estado_id}/cidades", method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findByEstado(@PathVariable Integer estado_id){
		List<Cidade> list = cs.findAllByEstado(estado_id);
		
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
