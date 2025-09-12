package teste101;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraPosFixadaTest {
	private CalculadoraPosFixada calculadoraPosFixada = new CalculadoraPosFixada();
	
	@Test
	@DisplayName("Deve retornar corretamente a soma de uma expressão simples")
	void somar() {
		assertEquals(6, calculadoraPosFixada.avaliar("2 4 +"));
	}
	
	@Test
	@DisplayName("Deve retornar corretamente a subtração de uma expressão simples")
	void diferenca() {
		assertEquals(5, calculadoraPosFixada.avaliar("10 5 -"));
	}
	
	@Test
	@DisplayName("Deve multiplicar corretamente uma expressão simples")
	void multiplicacao() {
		assertEquals(10, calculadoraPosFixada.avaliar("5 2 *"));
	}
	
	@Test
	@DisplayName("Deve processar corretamente a divisão de uma expressão simples")
	void dividir() {
		assertEquals(10, calculadoraPosFixada.avaliar("20 2 /"));
	}
}
