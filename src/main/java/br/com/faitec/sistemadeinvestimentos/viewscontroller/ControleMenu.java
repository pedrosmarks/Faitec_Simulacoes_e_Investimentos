package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.IOException;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import javafx.fxml.FXML;

public class ControleMenu {
    public static final String FXML_PATH = "tela_menu_selecao.fxml";

    @FXML
    protected void onMaterialClick() throws IOException {
	ControladorDeCena.trocarCena(ControleMaterial.FXML_PATH);
    }

    @FXML
    protected void onSimulacaoClick() throws IOException {
	ControladorDeCena.trocarCena(ControleEscolhaSimulacao.FXML_PATH);
    }


    @FXML
    protected void deslogar() throws IOException{
        ControladorDeCena.trocarCena(ControleLogin.FXML_PATH);
    }
}
