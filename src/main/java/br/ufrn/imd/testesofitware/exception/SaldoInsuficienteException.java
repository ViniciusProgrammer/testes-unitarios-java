package br.ufrn.imd.testesofitware.exception;

public class SaldoInsuficienteException extends RuntimeException {
	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}
}
