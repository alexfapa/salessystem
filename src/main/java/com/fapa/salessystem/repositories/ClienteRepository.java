package com.fapa.salessystem.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fapa.salessystem.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	
	/* A anotação @Transactional(readOnly = true) serve para que não seja envolvida uma transação de banco de dados
	 *  tornando assim a operação mais rápida evitando o locking de uma transação de banco de dados
	 *  
	 *  O Método findByEmail serve para realizar a busca de cliente por email no banco de dados. 
	 *  Obs.: apenas está anotação fará com que o framework crie o método
	 * */
	@Transactional(readOnly = true) 	
	Cliente findByEmail(String email);
}
