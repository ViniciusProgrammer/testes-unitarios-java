package teste101;

import java.util.Stack;

public class CalculadoraPosFixada {
	Stack<Integer> pilha = new Stack<>();
	
	public int avaliar(String expressao) {
		for(String operador : expressao.split("\\s+")) {
			if(ehOperador(operador)) {
				int a = pilha.pop();
				int b = pilha.pop();
				
				pilha.push(executaOperacao(a, b, operador));
			} else {
				pilha.push(Integer.parseInt(operador));
			}
		}
		return pilha.pop();
	}
	
	private boolean ehOperador(String token) {
		return "+-*/".contains(token);
	}
	
	private int executaOperacao(int a, int b, String operador) {
		return switch (operador) {
			case "+" -> a + b;
			case "-" -> a - b;
			case "*" -> a * b;
			case "/" -> a / b;
			default -> throw new IllegalArgumentException("Unexpected value: " + operador); 
		};
	}
}