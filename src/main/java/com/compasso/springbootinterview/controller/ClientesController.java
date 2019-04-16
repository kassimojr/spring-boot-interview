package com.compasso.springbootinterview.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compasso.springbootinterview.domain.Cliente;
import com.compasso.springbootinterview.service.ClienteService;

@RestController
@RequestMapping(value = "clientes")
public class ClientesController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.listar());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {
		Cliente cliente = clienteService.buscarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
	
	@RequestMapping(value = "nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorNome(@PathVariable("nome") String nome) {
		Cliente cliente = null;
		cliente = clienteService.buscarPorNome(nome);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Cliente cliente) {
		cliente = clienteService.salvar(cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/nome/{nome}")
				.buildAndExpand(cliente.getNome()).toUri();
		return ResponseEntity.created(location).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		clienteService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Cliente cliente, @PathVariable("id") Long id) {
		cliente.setId(id);
		clienteService.atualizarNome(cliente);
		return ResponseEntity.noContent().build();
	}
	
}
