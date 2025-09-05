package teste101;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraAddTest {
	
	private Calculadora calculadora;
	
	@BeforeEach
	void setup() {
		calculadora = new Calculadora(OperationType.ADD);
	}
	
	@Test
	@DisplayName("Expressão simples deve ser avaliada corretamente usando Enum")
	void deveSomarCorretamenteUsandoOperadorEnum() {
		int resultado = calculadora.avaliar("1+6+13");
		
		assertEquals(20, resultado);
	}
}
