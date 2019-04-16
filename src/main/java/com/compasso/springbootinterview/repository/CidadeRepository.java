package com.compasso.springbootinterview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.compasso.springbootinterview.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	@Query("select c from Cidade c where c.nome = ?1")
	public Cidade findByNome(String nome);

	@Query(value = "select * from Cidade c where c.estado = ?1 limit 1", nativeQuery=true)
	public Cidade findByEstado(String estado);
}
