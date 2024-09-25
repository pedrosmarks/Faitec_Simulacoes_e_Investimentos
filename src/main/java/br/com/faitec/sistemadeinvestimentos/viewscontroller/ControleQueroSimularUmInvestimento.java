package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.IOException;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import br.com.faitec.sistemadeinvestimentos.simulacao.Investimento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ControleQueroSimularUmInvestimento {
    public static final String FXML_PATH = "tela_quero_simular_um_investimento.fxml";

    private DataContainer dataContainer;

    public ControleQueroSimularUmInvestimento(DataContainer dataContainer) {
	this.dataContainer = dataContainer;
    }

    @FXML
    protected void retorna() throws IOException {
	ControladorDeCena.trocarCena(new ControleEscolhaSimulacao(dataContainer), ControleEscolhaSimulacao.FXML_PATH);
    }

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    public void initialize() {
	ObservableList<String> options = FXCollections.observableArrayList("Poupança", "Tesouro Direto", "Debêntures",
		"CDB", "Fundos Imobiliarios", "Bolsa de Valores", "Criptomoedas", "Day Trade");

	choiceBox.setItems(options);
    }

    @FXML
    private TextField valorInicial;

    @FXML
    private TextField depositoMensal;

    @FXML
    private TextField tempoInvestimento;

    @FXML
    protected void simular() throws IOException {

	int investimentoTipo = 0;

	if (choiceBox.getValue().equals("Poupança")) {
	    investimentoTipo = 1;
	} else if (choiceBox.getValue().equals("Tesouro Direto")) {
	    investimentoTipo = 2;
	} else if (choiceBox.getValue().equals("Debêntures")) {
	    investimentoTipo = 3;
	} else if (choiceBox.getValue().equals("CDB")) {
	    investimentoTipo = 4;
	} else if (choiceBox.getValue().equals("Fundos Imobiliarios")) {
	    investimentoTipo = 5;
	} else if (choiceBox.getValue().equals("Bolsa de Valores")) {
	    investimentoTipo = 6;
	} else if (choiceBox.getValue().equals("Criptomoedas")) {
	    investimentoTipo = 7;
	} else {
	    investimentoTipo = 8;
	}

	String inicial = valorInicial.getText();
	String mensal = depositoMensal.getText();
	int tempo = Integer.parseInt(tempoInvestimento.getText());

	dataContainer.setInvestimentoTipo(investimentoTipo);
	dataContainer.setInvestimentoValorInicial(inicial);
	dataContainer.setInvestimentoValorMensal(mensal);
	dataContainer.setInvestimentoDuracao(tempo);

	dataContainer.setInvestimentoValorFinal(Investimento.simularInvestimento(dataContainer));

	ControladorDeCena.trocarCena(new ControleResultadoInvestimento(dataContainer),
		ControleResultadoInvestimento.FXML_PATH);
    }

}
