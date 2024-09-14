package br.com.faitec.sistemadeinvestimentos.simulacao;

import java.util.Scanner;

public class Investimento {


    public static void simularInvestimento() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Escolha o tipo de investimento:");
        System.out.println("1. Poupança");
        System.out.println("2. Tesouro Direto");
        System.out.println("3. CDBs");
        System.out.println("4. Debêntures");
        System.out.println("5. Fundos Imobiliários");
        System.out.println("6. Bolsa de Valores");
        System.out.println("7. Criptomoedas");
        System.out.println("8. Day Trade");
        int tipoInvestimento = scanner.nextInt();

        System.out.println("Entre com o valor inicial: ");
        double valorInicial = scanner.nextDouble();

        System.out.println("Entre com o valor mensal: ");
        double valorMensal = scanner.nextDouble();

        System.out.println("Entre com o período em meses: ");
        int meses = scanner.nextInt();

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


