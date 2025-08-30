package br.ufrn.imd.testesofitware;

public class Calculadora {
	public static int soma(int num1, int num2) {
		return num1 + num2;
	}
	
	public static int subtracao(int num1, int num2) {
		if(num1 > num2) {
			return num1 - num2;
		} else {
			return num2 - num1;
		}
	}
	
	public static int multiplicacao(int num1, int num2) {
		return num1 * num2;
	}
	
	public static double dividir(double num1, double num2) {
		if(num2 != 0) {
			return num1 / num2;
		} else {
			throw new IllegalArgumentException("Não é possível didivir por 0");
		}
	}
}
