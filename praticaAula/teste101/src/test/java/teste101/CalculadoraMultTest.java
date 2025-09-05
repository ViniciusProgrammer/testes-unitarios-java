package teste101;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraMultTest {
	private Calculadora calculadora;
	
	@BeforeEach
	void setup() {
		calculadora = new Calculadora(OperationType.MULT);
	}
	
	@Test
	@DisplayName("Deve multiplicar corretamente os valores")
	void deveMultiplicarCorretamenteOsValores() {
		int resultado = calculadora.multiplicarValores("2*3*5");
		
		assertEquals(30, resultado);
	}
}
