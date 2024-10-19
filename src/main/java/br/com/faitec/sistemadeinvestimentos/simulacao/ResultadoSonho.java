package br.com.faitec.sistemadeinvestimentos.simulacao;

public class ResultadoSonho {

    private String investimento;
    private String risco;
    private String ganhos;
    private int tempoNecessario;

    public ResultadoSonho(String investimento, String risco, String ganhos, int tempoNecessario) {
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

    public String getGanhos() {
        return ganhos;
    }

    public void setGanhos(String ganhos) {
        this.ganhos = ganhos;
    }

    public int getTempoNecessario() {
        return tempoNecessario;
    }

    public void setTempoNecessario(int tempoNecessario) {
        this.tempoNecessario = tempoNecessario;
    }
}
