package br.com.faitec.sistemadeinvestimentos.simulacao;

import java.util.Scanner;

public class Sonho {

    public static void listarSonhos(){

        Scanner scanner = new Scanner(System.in);


        System.out.println("Entre com o valor que você precisa juntar: ");
        double valorQuePrecisa = scanner.nextDouble();

        System.out.println("Entre com o valor inicial:  ");
        double valorInicial = scanner.nextDouble();

        System.out.println("Entre com o deposito mensal: ");
        double depositoMensal = scanner.nextDouble();

        investimentos(valorQuePrecisa, valorInicial, depositoMensal);



    }



    public static void investimentos(double valorQuePrecisa, double valorInicial, double depositoMensal ){

        System.out.println("\nOpções de Investimentos:");

        calcularInvestimento("Poupança", valorQuePrecisa, valorInicial, depositoMensal, 0.005, "Baixo");
        calcularInvestimento("Tesouro Direto", valorQuePrecisa, valorInicial, depositoMensal, 0.005, "Baixo a Médio");
        calcularInvestimento("CDBs", valorQuePrecisa, valorInicial, depositoMensal, 0.006, "Baixo a Médio");
        calcularInvestimento("Debêntures", valorQuePrecisa, valorInicial, depositoMensal, 0.008, "Médio");
        calcularInvestimento("Fundos Imobiliários", valorQuePrecisa, valorInicial, depositoMensal, 0.007, "Médio");
        calcularInvestimento("Bolsa de Valores", valorQuePrecisa, valorInicial, depositoMensal, 0.01, "Alto");
        calcularInvestimento("Criptomoedas", valorQuePrecisa, valorInicial, depositoMensal, 0.02, "Muito Alto");
        calcularInvestimento("Day Trade", valorQuePrecisa, valorInicial, depositoMensal, 0.03, "Muito Alto");


    }

    public static void calcularInvestimento(String tipo, double valorQuePrecisa, double valorInicial, double depositoMensal, double taxaMensal, String risco) {
        double saldo = valorInicial;
        int meses = 0;

        while (saldo < valorQuePrecisa) {
            saldo += saldo * taxaMensal + depositoMensal;
            meses++;
        }

        System.out.println("\nInvestimento: " + tipo);
        System.out.println("Risco: " + risco);
        System.out.println("Ganhos: Aproximadamente " + (taxaMensal * 100) + "% ao mês");
        System.out.println("Tempo necessário para atingir o valor desejado: " + meses + " meses");
    }
}





