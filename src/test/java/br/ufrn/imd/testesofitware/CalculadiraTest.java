package br.ufrn.imd.testesofitware;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadiraTest {
	@Test
	public void somar() {
		int resultado = Calculadora.soma(12, 10);
		assertEquals(22, resultado, "O resultado deve retornar 22");
	}
}
