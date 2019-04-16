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

import com.compasso.springbootinterview.domain.Cidade;
import com.compasso.springbootinterview.service.CidadeService;
import com.compasso.springbootinterview.service.exception.CidadeNaoEncontradaException;

@RestController
@RequestMapping(value = "cidades")
public class CidadesController {

	@Autowired
	private CidadeService cidadeService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(cidadeService.listar());
	}

	@RequestMapping(value = "nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorNome(@PathVariable("nome") String nome) {
		Cidade cidade = cidadeService.buscarPorNome(nome);
		return ResponseEntity.status(HttpStatus.OK).body(cidade);
	}

	@RequestMapping(value = "estado/{estado}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorEstado(@PathVariable("estado") String estado) {
		Cidade cidade = cidadeService.buscarPorEstado(estado);
		return ResponseEntity.status(HttpStatus.OK).body(cidade);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Cidade cidade) {
		cidade = cidadeService.salvar(cidade);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/nome/{nome}")
				.buildAndExpand(cidade.getNome()).toUri();
		return ResponseEntity.created(location).build();
	}
}
