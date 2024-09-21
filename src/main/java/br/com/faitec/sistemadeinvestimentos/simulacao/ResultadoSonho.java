package br.com.faitec.sistemadeinvestimentos.simulacao;

public class ResultadoSonho {

    private String investimento;
    private String risco;
    private double ganhos;
    private int tempoNecessario;

    public ResultadoSonho(String investimento, String risco, double ganhos, int tempoNecessario) {
        this.investimento = investimento;
        this.risco = risco;
        this.ganhos = ganhos;
        this.tempoNecessario = tempoNecessario;
    }

    public String getInvestimento() {
        return investimento;
    }

    public void setInvestimento(String investimento) {
        this.investimento = investimento;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public double getGanhos() {
        return ganhos;
    }

    public void setGanhos(double ganhos) {
        this.ganhos = ganhos;
    }

    public int getTempoNecessario() {
        return tempoNecessario;
    }

    public void setTempoNecessario(int tempoNecessario) {
        this.tempoNecessario = tempoNecessario;
    }
}
