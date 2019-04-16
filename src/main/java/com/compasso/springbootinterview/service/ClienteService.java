package com.compasso.springbootinterview.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.compasso.springbootinterview.domain.Cliente;
import com.compasso.springbootinterview.repository.ClienteRepository;
import com.compasso.springbootinterview.service.exception.ClienteExistenteException;
import com.compasso.springbootinterview.service.exception.ClienteNaoEncontradoException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPorId (Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente == null) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado.");
		}
		return cliente.get();
	}
	
	public Cliente buscarPorNome (String nome) {
		Cliente cliente = clienteRepository.findByNome(nome);
		if (cliente == null) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado.");
		}
		return cliente;
	}
	
	public Cliente salvar(Cliente cliente) {
		if (cliente.getId() != null) {
			Cliente c = buscarPorId(cliente.getId());
			if (c != null) {
				throw new ClienteExistenteException("Cliente já existe.");
			}
		}
		return clienteRepository.save(cliente);
	}
	
	public void deletar(Long id) {
		try {
			clienteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException("Cliente não encontrado.");
		}
	}
	
	public void atualizarNome(Cliente cliente) {
		Cliente clienteRecuperado = buscarPorId(cliente.getId());
		clienteRecuperado.setNome(cliente.getNome());
		Cliente clienteAtualizado = new Cliente();
		clienteAtualizado = clienteRecuperado;
		clienteRepository.save(clienteAtualizado);
	}
}
