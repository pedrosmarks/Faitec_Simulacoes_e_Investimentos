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
	ControladorDeCena.trocarCena(new ControleEscolhaSimulacao(dataContainer), "tela_escolha_simulacao.fxml");
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

	int investimento = 0;

	if (choiceBox.getValue().equals("Poupança")) {
	    investimento = 1;
	} else if (choiceBox.getValue().equals("Tesouro Direto")) {
	    investimento = 2;
	} else if (choiceBox.getValue().equals("Debêntures")) {
	    investimento = 3;
	} else if (choiceBox.getValue().equals("CDB")) {
	    investimento = 4;
	} else if (choiceBox.getValue().equals("Fundos Imobiliarios")) {
	    investimento = 5;
	} else if (choiceBox.getValue().equals("Bolsa de Valores")) {
	    investimento = 6;
	} else if (choiceBox.getValue().equals("Criptomoedas")) {
	    investimento = 7;
	} else {
	    investimento = 8;
	}

	String inicial = valorInicial.getText();
	String mensal = depositoMensal.getText();
	int tempo = Integer.parseInt(tempoInvestimento.getText());

	Investimento.simularInvestimento(investimento, inicial, mensal, tempo);
    }

}
