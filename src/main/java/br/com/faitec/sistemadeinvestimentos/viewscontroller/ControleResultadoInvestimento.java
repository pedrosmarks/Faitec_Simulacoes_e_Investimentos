package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import br.com.faitec.sistemadeinvestimentos.simulacao.Investimento;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControleResultadoInvestimento {
    public static final String FXML_PATH = "tela_resultado_quero_simular_um_investimento.fxml";

    private DataContainer dataContainer;

    public ControleResultadoInvestimento(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    @FXML
    private Text resultadoInvestimento;

    @FXML
    protected void retorna() throws IOException {
        ControladorDeCena.trocarCena(new ControleQueroRealizarUmSonho(dataContainer),
                ControleQueroSimularUmInvestimento.FXML_PATH);
    }

    @FXML
    public void initialize() {
        // Pegua o valor final calculado
        double valorFinal = dataContainer.getInvestimentoValorFinalValue();
        // Formata como moeda brasileira
        String valorFormatado = Investimento.formatarComoMoeda(valorFinal);
        // Mostra na interface
        resultadoInvestimento.setText(valorFormatado);
    }
}
