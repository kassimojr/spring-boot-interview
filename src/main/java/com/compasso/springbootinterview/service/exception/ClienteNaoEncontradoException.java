package com.compasso.springbootinterview.service.exception;

public class ClienteNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1064009771372423835L;

	public ClienteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public ClienteNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
