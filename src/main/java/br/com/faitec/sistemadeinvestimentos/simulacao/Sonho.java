package br.com.faitec.sistemadeinvestimentos.simulacao;


import java.util.ArrayList;

public class Sonho {



    private double valorQuePrecisa;
    private double valorInicial;
    private double depositoMensal;

    public double getValorQuePrecisa() {
        return valorQuePrecisa;
    }

    public void setValorQuePrecisa(double valorQuePrecisa) {
        this.valorQuePrecisa = valorQuePrecisa;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getDepositoMensal() {
        return depositoMensal;
    }

    public void setDepositoMensal(double depositoMensal) {
        this.depositoMensal = depositoMensal;
    }

    public ArrayList<ResultadoSonho> investimentos(){




        ArrayList<ResultadoSonho> resultadoSonhos = new ArrayList<>();

        resultadoSonhos.add(calcularInvestimento("Poupança", valorQuePrecisa, valorInicial, depositoMensal, 0.005, "Baixo"));
        resultadoSonhos.add(calcularInvestimento("Tesouro Direto", valorQuePrecisa, valorInicial, depositoMensal, 0.005, "Baixo a Médio"));
        resultadoSonhos.add(calcularInvestimento("CDBs", valorQuePrecisa, valorInicial, depositoMensal, 0.006, "Baixo a Médio"));
        resultadoSonhos.add(calcularInvestimento("Debêntures", valorQuePrecisa, valorInicial, depositoMensal, 0.008, "Médio"));
        resultadoSonhos.add(calcularInvestimento("Fundos Imobiliários", valorQuePrecisa, valorInicial, depositoMensal, 0.007, "Médio"));
        resultadoSonhos.add(calcularInvestimento("Bolsa de Valores", valorQuePrecisa, valorInicial, depositoMensal, 0.01, "Alto"));
        resultadoSonhos.add(calcularInvestimento("Criptomoedas", valorQuePrecisa, valorInicial, depositoMensal, 0.02, "Muito Alto"));
        resultadoSonhos.add(calcularInvestimento("Day Trade", valorQuePrecisa, valorInicial, depositoMensal, 0.03, "Muito Alto"));

        return resultadoSonhos;

    }

    public static ResultadoSonho calcularInvestimento(String tipo, double valorQuePrecisa, double valorInicial, double depositoMensal, double taxaMensal, String risco) {
        double saldo = valorInicial;
        int meses = 0;

        while (saldo < valorQuePrecisa) {
            saldo += saldo * taxaMensal + depositoMensal;
            meses++;
        }

        return new ResultadoSonho(tipo,risco,saldo, meses);

    }



}






