package com.compasso.springbootinterview.service.exception;

public class ClienteExistenteException extends RuntimeException{

	private static final long serialVersionUID = -4807346105604899433L;

	public ClienteExistenteException(String mensagem) {
		super(mensagem);
	}

	public ClienteExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
