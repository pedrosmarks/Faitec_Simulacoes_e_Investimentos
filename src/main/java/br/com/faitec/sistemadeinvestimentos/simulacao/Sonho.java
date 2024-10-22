package br.com.faitec.sistemadeinvestimentos.simulacao;

import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

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

    public static ArrayList<ResultadoSonho> investimentos(DataContainer dataContainer) {

        ArrayList<ResultadoSonho> resultadoSonhos = new ArrayList<>();

        resultadoSonhos.add(calcularInvestimento("Poupança", dataContainer.getSonhoValorQuePrecisaValue(),
                dataContainer.getSonhoValorInicialValue(), dataContainer.getSonhoValorMensalValue(), 0.005, "Baixo"));
        resultadoSonhos.add(calcularInvestimento("Tesouro Direto", dataContainer.getSonhoValorQuePrecisaValue(),
                dataContainer.getSonhoValorInicialValue(), dataContainer.getSonhoValorMensalValue(), 0.005,
                "Baixo a Médio"));
        resultadoSonhos.add(calcularInvestimento("CDBs", dataContainer.getSonhoValorQuePrecisaValue(),
                dataContainer.getSonhoValorInicialValue(), dataContainer.getSonhoValorMensalValue(), 0.006,
                "Baixo a Médio"));
        resultadoSonhos.add(calcularInvestimento("Debêntures", dataContainer.getSonhoValorQuePrecisaValue(),
                dataContainer.getSonhoValorInicialValue(), dataContainer.getSonhoValorMensalValue(), 0.008, "Médio"));
        resultadoSonhos.add(calcularInvestimento("Fundos Imobiliários", dataContainer.getSonhoValorQuePrecisaValue(),
                dataContainer.getSonhoValorInicialValue(), dataContainer.getSonhoValorMensalValue(), 0.007, "Médio"));
        resultadoSonhos.add(calcularInvestimento("Bolsa de Valores", dataContainer.getSonhoValorQuePrecisaValue(),
                dataContainer.getSonhoValorInicialValue(), dataContainer.getSonhoValorMensalValue(), 0.01, "Alto"));
        resultadoSonhos.add(calcularInvestimento("Criptomoedas", dataContainer.getSonhoValorQuePrecisaValue(),
                dataContainer.getSonhoValorInicialValue(), dataContainer.getSonhoValorMensalValue(), 0.02,
                "Muito Alto"));
        resultadoSonhos.add(calcularInvestimento("Day Trade", dataContainer.getSonhoValorQuePrecisaValue(),
                dataContainer.getSonhoValorInicialValue(), dataContainer.getSonhoValorMensalValue(), 0.03,
                "Muito Alto"));

        return resultadoSonhos;
    }

    public static ResultadoSonho calcularInvestimento(String tipo, String valorQuePrecisaText, String valorInicialText,
                                                      String depositoMensalText, double taxaMensal, String risco) {

        double valorInicial = Double.parseDouble(valorInicialText);
        double depositoMensal = Double.parseDouble(depositoMensalText);
        double valorQuePrecisa = Double.parseDouble(valorQuePrecisaText);

        double saldo = valorInicial;
        int meses = 0;

        while (saldo < valorQuePrecisa) {
            saldo += saldo * taxaMensal + depositoMensal;
            meses++;
        }

        // Formatação final do saldo na moeda brasileira
        String saldoFormatado = formatarMoeda(saldo);

        return new ResultadoSonho(tipo, risco, saldoFormatado, meses);
    }

    // Metodo para formatar valores monetários
    private static String formatarMoeda(double valor) {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatoMoeda.format(valor);
    }
}
