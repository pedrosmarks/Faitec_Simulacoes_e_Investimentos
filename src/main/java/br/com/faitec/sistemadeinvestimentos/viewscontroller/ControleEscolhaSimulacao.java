package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.IOException;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import javafx.fxml.FXML;

public class ControleEscolhaSimulacao {
    public static final String FXML_PATH = "tela_escolha_simulacao.fxml";

    private DataContainer dataContainer;

    public ControleEscolhaSimulacao(DataContainer dataContainer) {
	this.dataContainer = dataContainer;
    }

    @FXML
    protected void simulaInvestimento() throws IOException {
	ControladorDeCena.trocarCena(new ControleQueroSimularUmInvestimento(dataContainer),
		"tela_quero_simular_um_investimento.fxml");
    }

    @FXML
    protected void simulaSonho() throws IOException {
	ControladorDeCena.trocarCena(new ControleQueroRealizarUmSonho(dataContainer),
		"tela_quero_realizar_um_sonho.fxml");
    }

    @FXML
    protected void retorna() throws IOException {
	ControladorDeCena.trocarCena(new ControleEscolhaSimulacao(dataContainer), "tela_menu_selecao.fxml");

    }

}
