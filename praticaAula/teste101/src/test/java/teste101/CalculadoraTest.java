package teste101;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
	
	/*
	@Test
	void test() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	@DisplayName("Expressão simples deve ser avaliada corretamente")
	void deveAvaliarCorretamente() {
		Calculadora calc = new Calculadora();
		
		int soma = calc.avaliar("1+2+3");
		
		assertEquals(6, soma);
	}
	
	@Test
	@DisplayName("A soma deve ser realizada sem problemas mesmo com espaços")
	void deveSomarExpressoesComEspacos() {
		Calculadora calculadora = new Calculadora();
		
		int soma = calculadora.somarComEspacos("1 + 2 + 3");
		
		assertEquals(6, soma);
	}
	
	@Test
	@DisplayName("A soma deve ser realizada independentemente do sinal do número")
	void deveSomarTambemNumerosNegativos() {
		Calculadora calculadora = new Calculadora();
		
		int soma = calculadora.somarNumeroIndependenteDoSinal("-1+2+3");
		
		assertEquals(4, soma);
	}
}
