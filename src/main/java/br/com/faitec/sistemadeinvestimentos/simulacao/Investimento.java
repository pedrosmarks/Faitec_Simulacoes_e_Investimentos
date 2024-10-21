package br.com.faitec.sistemadeinvestimentos.simulacao;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Investimento {

	public static double simularInvestimento(DataContainer dataContainer) throws IOException {
		int tipoInvestimento = dataContainer.getInvestimentoTipoValue();
		String inicial = dataContainer.getInvestimentoValorInicialValue();
		String mensal = dataContainer.getInvestimentoValorMensalValue();
		int meses = dataContainer.getInvestimentoDuracaoValue();

		double valorInicial = Double.parseDouble(inicial);
		double valorMensal = Double.parseDouble(mensal);
		double taxaJuros = obterTaxaJuros(tipoInvestimento);

		return calcularMontante(valorInicial, valorMensal, meses, taxaJuros);
	}

	private static double obterTaxaJuros(int tipoInvestimento) {
		switch (tipoInvestimento) {
			case 1:
				return 0.003; // Poupança
			case 2:
				return 0.005; // Tesouro Direto
			case 3:
				return 0.006; // CDBs
			case 4:
				return 0.007; // Debêntures
			case 5:
				return 0.008; // Fundos Imobiliários
			case 6:
				return 0.01; // Bolsa de Valores
			case 7:
				return 0.015; // Criptomoedas
			case 8:
				return 0.02; // Day Trade
			default:
				return 0;
		}
	}

	private static double calcularMontante(double valorInicial, double valorMensal, int meses, double taxaJuros) {
		double montante = valorInicial;
		for (int i = 0; i < meses; i++) {
			montante += valorMensal;
			montante += montante * taxaJuros;
		}
		return Math.round(montante * 100.0) / 100.0;
	}

	// Metodo para formatar o valor como moeda brasileira
	public static String formatarComoMoeda(double valor) {
		NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return formatoMoeda.format(valor);
	}
}

