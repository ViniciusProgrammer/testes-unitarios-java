package cashback;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContaCashback {

	private TipoPerfil perfil;
	private float saldo;
	
	// mexi aqui
	private List<RegistroCashback> historico;

	public ContaCashback(float saldoInicial, TipoPerfil perfil) {
		this.saldo = saldoInicial;
		this.perfil = perfil;
		
		//mexi aqui
		this.historico = new ArrayList<RegistroCashback>();
	}

	public void registrarPagamento(Pagamento pagamento) {
		TipoPagamento formaPagamento = pagamento.tipo;
		
		float percentual = 0.0f;

		if (TipoPagamento.CARTAO_CREDITO.equals(formaPagamento)) {
			if (TipoPerfil.ESSENCIAL.equals(this.perfil)) {
				percentual = 0.01f;
			} else if (TipoPerfil.ADITIVADO.equals(this.perfil)) {
				percentual = 0.02f;
			} else if (TipoPerfil.PREMIUM.equals(this.perfil)) {
				percentual = 0.06f;
			}
		} else if (TipoPagamento.PIX.equals(formaPagamento)) {
			if (TipoPerfil.ESSENCIAL.equals(this.perfil)) {
				percentual = 0.02f;
			} else if (TipoPerfil.ADITIVADO.equals(this.perfil)) {
				percentual = 0.04f;
			} else if (TipoPerfil.PREMIUM.equals(this.perfil)) {
				percentual = 0.06f;
			}
		}

		float cashback = pagamento.valor * percentual;
		if(cashback > 12.0f) {
			cashback = 12.0f;
		}
		
		//mexi aqui
		float acumulado7dias = getCashbackUltimos7Dias(pagamento.data);
		
		if(acumulado7dias >= 12.0f) {
			cashback = 0.0f;
		} else if(acumulado7dias + cashback > 12.0f) {
			cashback = 12.0f - acumulado7dias;
		}
				
		this.saldo += cashback;
		historico.add(new RegistroCashback(pagamento.data, cashback));
	}
	
	private float getCashbackUltimos7Dias(LocalDate referencia) {
		return (float) historico.stream().filter(r -> !r.data.isBefore(referencia.minusDays(6))).mapToDouble(r -> r.valor).sum();
	}

	public float consultarSaldo() {
		return this.saldo;
	}
	
	private static class RegistroCashback {
        LocalDate data;
        float valor;

        RegistroCashback(LocalDate data, float valor) {
            this.data = data;
            this.valor = valor;
        }
	}
}
