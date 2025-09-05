package teste101;

public class Calculadora {
	private final OperationType operacao;
	
	public Calculadora() {
		this.operacao = null;
		
	}
	
	public Calculadora(OperationType operacao) {
		this.operacao = operacao;
	}
	
	public int avaliar(String expressao) {
		int soma = 0;
		
		for(String arg : expressao.split("\\+")) {
			soma += Integer.valueOf(arg);
		}
		return soma;
	}
	
	public int somarComEspacos(String expressao) {
		int soma = 0;
		
		String expressaoSemEspacos = expressao.replaceAll("\\s", "");
		
		String [] parcelas = expressaoSemEspacos.split("\\+");
		
		for(String arg : parcelas) {
			soma += Integer.valueOf(arg);
		}
		
		return soma;
	}
	
	public int somarNumeroIndependenteDoSinal(String expressao) {
		int soma = 0;
		
		String expressaoComSinalNegativo = expressao.replace("\\-", "");
		
		String [] parcelas = expressaoComSinalNegativo.split("\\+");
		
		for(String arg : parcelas) {
			soma += Integer.valueOf(arg);
		}
		
		return soma;
	}
	
	public int multiplicarValores(String expressao) {
		int mult = 1;
		
		for(String arg : expressao.split("\\*")) {
			mult *= Integer.valueOf(arg);
		}
		
		return mult;
	}
}
