package com.compasso.springbootinterview.service.exception;

public class CidadeNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = -2243826917112687235L;

	public CidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public CidadeNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
