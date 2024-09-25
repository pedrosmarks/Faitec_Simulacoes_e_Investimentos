package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.IOException;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import br.com.faitec.sistemadeinvestimentos.simulacao.Sonho;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControleQueroRealizarUmSonho {
    public static final String FXML_PATH = "tela_quero_realizar_um_sonho.fxml";

    private DataContainer dataContainer;

    public ControleQueroRealizarUmSonho(DataContainer dataContainer) {
	this.dataContainer = dataContainer;
    }

    @FXML
    protected void retorna() throws IOException {
	ControladorDeCena.trocarCena(new ControleEscolhaSimulacao(dataContainer), ControleEscolhaSimulacao.FXML_PATH);
    }

    @FXML
    private TextField valorQuePrecisa;

    @FXML
    private TextField valorInicial;

    @FXML
    private TextField valorMensal;

    @FXML
    protected void simular() throws IOException {

	dataContainer.setSonhoValorQuePrecisa(valorQuePrecisa.getText());
	dataContainer.setSonhoValorInicial(valorInicial.getText());
	dataContainer.setSonhoValorMensal(valorMensal.getText());

	dataContainer.setResultadoSonhos(Sonho.investimentos(dataContainer));

	ControladorDeCena.trocarCena(new ControleResultadoSonho(dataContainer), ControleResultadoSonho.FXML_PATH);
    }

}
