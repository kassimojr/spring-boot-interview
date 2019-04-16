package com.compasso.springbootinterview.service.exception;

public class EstadoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = -5524398085395114636L;

	public EstadoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public EstadoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
