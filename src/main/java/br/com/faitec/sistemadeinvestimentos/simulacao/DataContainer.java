package br.com.faitec.sistemadeinvestimentos.simulacao;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataContainer {

    private StringProperty sonhoValorQuePrecisa = new SimpleStringProperty();
    private StringProperty sonhoValorInicial = new SimpleStringProperty();
    private StringProperty sonhoValorMensal = new SimpleStringProperty();

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
}
