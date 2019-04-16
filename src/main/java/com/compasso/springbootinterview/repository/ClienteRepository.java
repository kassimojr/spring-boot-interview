package com.compasso.springbootinterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.compasso.springbootinterview.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("select c from Cliente c where c.nome = ?1")
	public Cliente findByNome(String nome);
}
