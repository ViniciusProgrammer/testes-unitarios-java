package cashback;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ContaCashbackTest {
	// mexi aqui
	private ContaCashback conta;
	
	@BeforeEach
	void setUp() {
		conta = new ContaCashback(0, TipoPerfil.PREMIUM);
	}
	
	//mexi
	@Test
	void deveRespeitarLimiteDe7Dias() {
		Pagamento p1 = new Pagamento(1000f, TipoPagamento.CARTAO_CREDITO, LocalDate.now());
		Pagamento p2 = new Pagamento(1000f, TipoPagamento.CARTAO_CREDITO, LocalDate.now());
	
		conta.registrarPagamento(p1);
		conta.registrarPagamento(p2);
		
		assertEquals(12.0f, conta.consultarSaldo());
	}
	
	//mexi
	@Test
	void deveLiberarNovoLimiteApos7Dias() {
		Pagamento p1 = new Pagamento(1000f, TipoPagamento.CARTAO_CREDITO, LocalDate.now());
		Pagamento p2 = new Pagamento(1000f, TipoPagamento.CARTAO_CREDITO, LocalDate.now().plusDays(8));		
		
		conta.registrarPagamento(p1);
		conta.registrarPagamento(p2);
		
		assertEquals(24.0f, conta.consultarSaldo());
	}
	
	//mexi
	@Test
	void deveAcumularSemUltrapassar12DentroDoPeriodo() {
		Pagamento p1 = new Pagamento(100f, TipoPagamento.CARTAO_CREDITO, LocalDate.now());
		Pagamento p2 = new Pagamento(100f, TipoPagamento.CARTAO_CREDITO, LocalDate.now().plusDays(1));
		Pagamento p3 = new Pagamento(100f, TipoPagamento.CARTAO_CREDITO, LocalDate.now().plusDays(2));
	
		conta.registrarPagamento(p1);
		conta.registrarPagamento(p2);
		conta.registrarPagamento(p3);
	
		assertEquals(12.0f, conta.consultarSaldo());
	}
	
	@ParameterizedTest
	@CsvSource(value = {//
			"ESSENCIAL, 100.0f, CARTAO_CREDITO, 1.0f",//
			"ESSENCIAL, 100.0f, PIX, 2.0f",//
			"ESSENCIAL, 100.0f, VALE_PREMIA, 0.0f",//
			"ADITIVADO, 100.0f, CARTAO_CREDITO, 2.0f",//
			"ADITIVADO, 100.0f, PIX, 4.0f",//
			"ADITIVADO, 100.0f, VALE_PREMIA, 0.0f",//
			"PREMIUM, 100.0f, CARTAO_CREDITO, 6.0f",//
			"PREMIUM, 100.0f, PIX, 6.0f",//
			"PREMIUM, 100.0f, VALE_PREMIA, 0.0f",//
	})
	void testeContaEssencialCartaoCreditoRetorna1PorCento(TipoPerfil perfil, float valorPagamento, TipoPagamento formaPagamento, Float saldoEsperado) {
		float saldoInicial = 0.0f;
		
		ContaCashback conta = new ContaCashback(saldoInicial, perfil);
		Pagamento pagamento = new Pagamento(valorPagamento, formaPagamento, LocalDate.now());
		conta.registrarPagamento(pagamento);
		
		float saldoRetornado = conta.consultarSaldo();
		
		assertEquals(saldoEsperado, saldoRetornado);
	}
	
	@ParameterizedTest
	@CsvSource(value = {//
			"ESSENCIAL, 1500.0f, CARTAO_CREDITO",//
			"ADITIVADO, 1500.0f, CARTAO_CREDITO",//
	})
	void testeLimiteDeDozePorTransacao(TipoPerfil perfil, float valorPagamento, TipoPagamento formaPagamento) {
		float saldoInicial = 0.0f;
		
		ContaCashback conta = new ContaCashback(saldoInicial, perfil);
		Pagamento pagamento = new Pagamento(valorPagamento, formaPagamento, LocalDate.now());
		conta.registrarPagamento(pagamento);
		
		float saldoRetornado = conta.consultarSaldo();
		
		assertEquals(12.0, saldoRetornado);
	}
	
	@Test
	void testeVariosPagamentos() {
		float saldoInicial = 0.0f;
		
		ContaCashback conta = new ContaCashback(saldoInicial, TipoPerfil.PREMIUM);
		LocalDate hoje = LocalDate.now();
		LocalDate ontem = hoje.minusDays(1);
		Pagamento pagamento1 = new Pagamento(1500.0f, TipoPagamento.CARTAO_CREDITO, ontem);
		Pagamento pagamento2 = new Pagamento(1500.0f, TipoPagamento.CARTAO_CREDITO, hoje);
		conta.registrarPagamento(pagamento1);
		conta.registrarPagamento(pagamento2);
		
		float saldoRetornado = conta.consultarSaldo();
		
		assertEquals(12.0, saldoRetornado);
	}
	
	
}
