package br.ufrn.imd.testesofitware;

import br.ufrn.imd.testesofitware.exception.SaldoInsuficienteException;

public class ContaBancaria {
	private String titular;
	private double saldo;
	private int numeroDaConta;
	
	public ContaBancaria() {
		
	}
	
	public ContaBancaria(String titular, double saldo, int numeroDaConta) {
		this.titular = titular;
		this.saldo = saldo;
		this.numeroDaConta = numeroDaConta;
	}
	
	public void depositar(double valor) {
		if(valor > 0) {
			this.saldo += valor;
		} else {
			throw new IllegalArgumentException("O valor deve ser positivo");
		}
	}
	
	public void sacar(double valor) {
		if(saldo >= valor) {
			this.saldo -= valor;
		} else {
			throw new SaldoInsuficienteException("Saldo insuficiente para o saque");
		}
	}
	
	public void transferir(ContaBancaria destino, double valor) {
		if(valor > saldo) {
			throw new IllegalArgumentException("Saldo insuficiente para transferência");
		} else {
			this.sacar(valor);
			destino.depositar(valor);
		}
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(int numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}
}
