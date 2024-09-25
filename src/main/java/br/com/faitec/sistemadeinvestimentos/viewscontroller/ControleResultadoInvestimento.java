package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ControleResultadoInvestimento {
    public static final String FXML_PATH = "tela_resultado_quero_simular_um_investimento.fxml";

    private DataContainer dataContainer;

    public ControleResultadoInvestimento(DataContainer dataContainer) {
	this.dataContainer = dataContainer;
    }

    @FXML
    private Text resultadoInvestimento;

    @FXML
    public void initialize() {
	resultadoInvestimento.setText(String.valueOf(dataContainer.getInvestimentoValorFinalValue()));
    }
}
