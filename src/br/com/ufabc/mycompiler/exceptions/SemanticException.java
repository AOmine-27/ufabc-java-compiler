package br.com.ufabc.mycompiler.exceptions;

public class SemanticException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SemanticException(String msg) {
		super(msg);
	}
}
