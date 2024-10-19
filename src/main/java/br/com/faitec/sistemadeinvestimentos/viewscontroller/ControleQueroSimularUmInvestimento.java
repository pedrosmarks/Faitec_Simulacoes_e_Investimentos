package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.IOException;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import br.com.faitec.sistemadeinvestimentos.simulacao.Investimento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        try {
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

            // Tentando converter os valores digitados para números
            String inicial = valorInicial.getText();
            String mensal = depositoMensal.getText();
            int tempo = Integer.parseInt(tempoInvestimento.getText());

            double valorInicial = Double.parseDouble(inicial);
            double valorMensal = Double.parseDouble(mensal);

            dataContainer.setInvestimentoTipo(investimentoTipo);
            dataContainer.setInvestimentoValorInicial(inicial);
            dataContainer.setInvestimentoValorMensal(mensal);
            dataContainer.setInvestimentoDuracao(tempo);

            // Cálculo do valor final
            double valorFinal = Investimento.simularInvestimento(dataContainer);
            dataContainer.setInvestimentoValorFinal(valorFinal);

            ControladorDeCena.trocarCena(new ControleResultadoInvestimento(dataContainer), ControleResultadoInvestimento.FXML_PATH);

        } catch (NumberFormatException e) {
            // Exibindo um alerta se o usuário inserir algo que não seja numérico
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de Formato");
            alert.setHeaderText("Valor inválido");
            alert.setContentText("Por favor, insira apenas valores numéricos válidos.");
            alert.showAndWait();
        }
    }
}