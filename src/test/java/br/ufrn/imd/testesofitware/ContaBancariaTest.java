package br.ufrn.imd.testesofitware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ufrn.imd.testesofitware.exception.SaldoInsuficienteException;

public class ContaBancariaTest {
	@Test
	public void deveLancarExcessaoAoSacaComSaldoInsuficiente() {
		ContaBancaria contaBancaria = new ContaBancaria("Vinicios", 100, 123);
		
		assertThrows(SaldoInsuficienteException.class, () -> {
			contaBancaria.sacar(200);
		});
	}
	
	public void deveLancarExcessaoTransferirComSaldoInsuficiente() {
		ContaBancaria contaBancariaOrigem = new ContaBancaria("Ana", 200, 546);
		ContaBancaria contaBancariaDestino = new ContaBancaria("Pedro", 100, 105);
		
		assertThrows(SaldoInsuficienteException.class, () -> {
			contaBancariaOrigem.transferir(contaBancariaDestino, 300);
		});
	}
}
