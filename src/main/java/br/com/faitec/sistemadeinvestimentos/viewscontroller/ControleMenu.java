package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.IOException;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import javafx.fxml.FXML;

public class ControleMenu {
    public static final String FXML_PATH = "tela-menu-selecao.fxml";

    @FXML
    protected void onMaterialClick() throws IOException {
	ControladorDeCena.trocarCena(ControleMaterial.FXML_PATH);
    }

    @FXML
    protected void onSimulacaoClick() throws IOException {
	ControladorDeCena.trocarCena(ControleEscolhaSimlacao.FXML_PATH);
    }
}
