package com.compasso.springbootinterview.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.compasso.springbootinterview.domain.Cidade;
import com.compasso.springbootinterview.domain.Cliente;
import com.compasso.springbootinterview.repository.CidadeRepository;
import com.compasso.springbootinterview.service.exception.CidadeExistenteException;
import com.compasso.springbootinterview.service.exception.CidadeNaoEncontradaException;
import com.compasso.springbootinterview.service.exception.ClienteExistenteException;
import com.compasso.springbootinterview.service.exception.EstadoNaoEncontradoException;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> listar(){
		return cidadeRepository.findAll();
	}
	
	public Cidade buscarPorId (Long id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		if (cidade == null) {
			throw new CidadeNaoEncontradaException("Cidade não encontrada.");
		}
		return cidade.get();
	}
	
	public Cidade buscarPorNome (String nome) {
		Cidade cidade = cidadeRepository.findByNome(nome);
		if (cidade == null) {
			throw new CidadeNaoEncontradaException("Cidade não encontrada.");
		}
		return cidade;
	}
	
	public Cidade buscarPorEstado (String estado) {
		Cidade cidade = cidadeRepository.findByEstado(estado);
		if (cidade == null) {
			throw new EstadoNaoEncontradoException("Estado não encontrado.");
		}
		return cidade;
	}
	
	public Cidade salvar(Cidade cidade) {
		if (cidade.getId() != null) {
			Cidade c = buscarPorId(cidade.getId());
			if (c != null) {
				throw new CidadeExistenteException("Cidade já existe.");
			}
		}
		return cidadeRepository.save(cidade);
	}
}
