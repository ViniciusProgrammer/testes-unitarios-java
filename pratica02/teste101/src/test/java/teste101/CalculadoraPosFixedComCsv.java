package teste101;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculadoraPosFixedComCsv {
	private final CalculadoraPosFixada calculadoraPosFixada = new CalculadoraPosFixada();
	
	@ParameterizedTest(name = "Expressão \"{0}\" deve resultar em {1}")
    @CsvSource({
        "'3 4 +', 7",
        "'5 3 -', 2",
        "'3 5 *', 15",
        "'20 5 /', 4",
        "'5 9 + 2 *', 28"
    })
	void deveAvaliarCorretamenteExpressoesComCsv(String expressao, int esperado) {
		assertEquals(esperado, calculadoraPosFixada.avaliar(expressao));
	}
}
