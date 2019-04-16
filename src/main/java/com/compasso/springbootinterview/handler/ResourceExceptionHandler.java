package com.compasso.springbootinterview.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.compasso.springbootinterview.domain.PayloadErrorMessage;
import com.compasso.springbootinterview.service.exception.CidadeExistenteException;
import com.compasso.springbootinterview.service.exception.CidadeNaoEncontradaException;
import com.compasso.springbootinterview.service.exception.ClienteExistenteException;
import com.compasso.springbootinterview.service.exception.ClienteNaoEncontradoException;
import com.compasso.springbootinterview.service.exception.EstadoNaoEncontradoException;

public class ResourceExceptionHandler {
	
	@ExceptionHandler(CidadeNaoEncontradaException.class)
	public ResponseEntity<PayloadErrorMessage> handleCidadeNaoEncontradaException
							(CidadeNaoEncontradaException e, HttpServletRequest request) {
		
		PayloadErrorMessage errorMessage = new PayloadErrorMessage();
		errorMessage.setMensagem("Cidade não encontrada");
		errorMessage.setStatus(404l);
		errorMessage.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
	
	@ExceptionHandler(EstadoNaoEncontradoException.class)
	public ResponseEntity<PayloadErrorMessage> handleEstadoNaoEncontradoException
							(EstadoNaoEncontradoException e, HttpServletRequest request) {
		
		PayloadErrorMessage errorMessage = new PayloadErrorMessage();
		errorMessage.setMensagem("Estado não encontrado");
		errorMessage.setStatus(404l);
		errorMessage.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
	
	@ExceptionHandler(CidadeExistenteException.class)
	public ResponseEntity<PayloadErrorMessage> handleCidadeExistenteException
							(CidadeExistenteException e, HttpServletRequest request) {
		
		PayloadErrorMessage errorMessage = new PayloadErrorMessage();
		errorMessage.setMensagem("Cidade já existe");
		errorMessage.setStatus(409l);
		errorMessage.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
	}
	
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<PayloadErrorMessage> handleClienteNaoEncontradoException
							(ClienteNaoEncontradoException e, HttpServletRequest request) {
		
		PayloadErrorMessage errorMessage = new PayloadErrorMessage();
		errorMessage.setMensagem("Cliente não encontrado");
		errorMessage.setStatus(404l);
		errorMessage.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
	
	@ExceptionHandler(ClienteExistenteException.class)
	public ResponseEntity<PayloadErrorMessage> handleClienteExistenteException
							(ClienteExistenteException e, HttpServletRequest request) {
		
		PayloadErrorMessage errorMessage = new PayloadErrorMessage();
		errorMessage.setMensagem("Cliente já existe");
		errorMessage.setStatus(409l);
		errorMessage.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<PayloadErrorMessage> handleDataIntegrityViolationException
	(DataIntegrityViolationException e, HttpServletRequest request) {
		
		PayloadErrorMessage errorMessage = new PayloadErrorMessage();
		errorMessage.setMensagem("Requisição inválida");
		errorMessage.setStatus(400l);
		errorMessage.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<PayloadErrorMessage> handleHttpMessageNotReadableException
	(HttpMessageNotReadableException e, HttpServletRequest request) {
		
		PayloadErrorMessage errorMessage = new PayloadErrorMessage();
		errorMessage.setMensagem("Formato de entrada inválido");
		errorMessage.setStatus(400l);
		errorMessage.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	}
	
}
