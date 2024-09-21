package br.com.faitec.sistemadeinvestimentos.simulacao;


import java.io.IOException;

public class Investimento {


    public static void simularInvestimento(int tipoInvestimento, String inicial, String mensal, int meses ) throws IOException {

        double valorInicial = Double.parseDouble(inicial);

        double valorMensal = Double.parseDouble(mensal);



        double taxaJuros = obterTaxaJuros(tipoInvestimento);
        double montanteFinal = calcularMontante(valorInicial, valorMensal, meses, taxaJuros);

        System.out.printf("O montante final após %d meses será: R$ %.2f%n", meses, montanteFinal);


    }

    private static double obterTaxaJuros(int tipoInvestimento) {
        switch (tipoInvestimento) {
            case 1: return 0.003; // Poupança
            case 2: return 0.005; // Tesouro Direto
            case 3: return 0.006; // CDBs
            case 4: return 0.007; // Debêntures
            case 5: return 0.008; // Fundos Imobiliários
            case 6: return 0.01;  // Bolsa de Valores
            case 7: return 0.015; // Criptomoedas
            case 8: return 0.02;  // Day Trade
            default: return 0;
        }
    }

    private static double calcularMontante(double valorInicial, double valorMensal, int meses, double taxaJuros) {
        double montante = valorInicial;
        for (int i = 0; i < meses; i++) {
            montante += valorMensal;
            montante += montante * taxaJuros;
        }
        return montante;
    }
}


