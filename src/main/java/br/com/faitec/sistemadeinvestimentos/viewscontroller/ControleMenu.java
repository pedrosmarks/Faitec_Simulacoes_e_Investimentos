package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.IOException;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import javafx.fxml.FXML;

public class ControleMenu {
    public static final String FXML_PATH = "tela_menu_selecao.fxml";

    private DataContainer dataContainer;

    public ControleMenu(DataContainer dataContainer) {
	this.dataContainer = dataContainer;
    }

    @FXML
    protected void onMaterialClick() throws IOException {
	ControladorDeCena.trocarCena(new ControleMaterial(dataContainer), ControleMaterial.FXML_PATH);
    }

    @FXML
    protected void onSimulacaoClick() throws IOException {
	ControladorDeCena.trocarCena(new ControleEscolhaSimulacao(dataContainer), ControleEscolhaSimulacao.FXML_PATH);
    }

    @FXML
    protected void deslogar() throws IOException {
	ControladorDeCena.trocarCena(new ControleLogin(dataContainer), ControleLogin.FXML_PATH);
    }
}
