package br.com.faitec.sistemadeinvestimentos.simulacao;

import java.util.ArrayList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataContainer {

    private StringProperty sonhoValorQuePrecisa = new SimpleStringProperty();
    private StringProperty sonhoValorInicial = new SimpleStringProperty();
    private StringProperty sonhoValorMensal = new SimpleStringProperty();
    private ArrayList<ResultadoSonho> resultadoSonhos;

    private IntegerProperty investimentoTipo = new SimpleIntegerProperty();
    private StringProperty investimentoValorInicial = new SimpleStringProperty();
    private StringProperty investimentoValorMensal = new SimpleStringProperty();
    private IntegerProperty investimentoDuracao = new SimpleIntegerProperty();
    private DoubleProperty investimentoValorFinal = new SimpleDoubleProperty();

    public StringProperty sonhoValorQuePrecisaProperty() {
        return sonhoValorQuePrecisa;
    }

    public String getSonhoValorQuePrecisaValue() {
        return sonhoValorQuePrecisaProperty().get();
    }

    public void setSonhoValorQuePrecisa(String sonhoValorQuePrecisa) {
        sonhoValorQuePrecisaProperty().set(sonhoValorQuePrecisa);
    }

    public StringProperty sonhoValorInicialProperty() {
        return sonhoValorInicial;
    }

    public String getSonhoValorInicialValue() {
        return sonhoValorInicialProperty().get();
    }

    public void setSonhoValorInicial(String sonhoValorInicial) {
        sonhoValorInicialProperty().set(sonhoValorInicial);
    }

    public StringProperty sonhoValorMensalProperty() {
        return sonhoValorMensal;
    }

    public String getSonhoValorMensalValue() {
        return sonhoValorMensalProperty().get();
    }

    public void setSonhoValorMensal(String sonhoValorMensal) {
        sonhoValorMensalProperty().set(sonhoValorMensal);
    }

    public ArrayList<ResultadoSonho> getResultadoSonhos() {
        return resultadoSonhos;
    }

    public void setResultadoSonhos(ArrayList<ResultadoSonho> resultadoSonhos) {
        this.resultadoSonhos = resultadoSonhos;
    }

    public IntegerProperty investimentoTipoProperty() {
        return investimentoTipo;
    }

    public int getInvestimentoTipoValue() {
        return investimentoTipoProperty().get();
    }

    public void setInvestimentoTipo(int investimentoTipo) {
        investimentoTipoProperty().set(investimentoTipo);
    }

    public StringProperty investimentoValorInicialProperty() {
        return investimentoValorInicial;
    }

    public String getInvestimentoValorInicialValue() {
        return investimentoValorInicialProperty().get();
    }

    public void setInvestimentoValorInicial(String investimentoValorInicial) {
        investimentoValorInicialProperty().set(investimentoValorInicial);
    }

    public StringProperty investimentoValorMensalProperty() {
        return investimentoValorMensal;
    }

    public String getInvestimentoValorMensalValue() {
        return investimentoValorMensalProperty().get();
    }

    public void setInvestimentoValorMensal(String investimentoValorMensal) {
        investimentoValorMensalProperty().set(investimentoValorMensal);
    }

    public IntegerProperty investimentoDuracaoProperty() {
        return investimentoDuracao;
    }

    public int getInvestimentoDuracaoValue() {
        return investimentoDuracaoProperty().get();
    }

    public void setInvestimentoDuracao(int investimentoDuracao) {
        investimentoDuracaoProperty().set(investimentoDuracao);
    }

    public DoubleProperty investimentoValorFinalProperty() {
        return investimentoValorFinal;
    }

    public Double getInvestimentoValorFinalValue() {
        return investimentoValorFinalProperty().get();
    }

    public void setInvestimentoValorFinal(Double investimentoValorFinal) {
        investimentoValorFinalProperty().set(investimentoValorFinal);
    }
}
