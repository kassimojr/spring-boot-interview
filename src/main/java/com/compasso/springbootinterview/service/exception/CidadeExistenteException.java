package com.compasso.springbootinterview.service.exception;

public class CidadeExistenteException extends RuntimeException{

	private static final long serialVersionUID = 1064009771372423835L;

	public CidadeExistenteException(String mensagem) {
		super(mensagem);
	}

	public CidadeExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
