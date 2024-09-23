package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.IOException;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import javafx.fxml.FXML;

public class ControleMaterial {
    public static final String FXML_PATH = "tela_download_materiais.fxml";

    private DataContainer dataContainer;

    public ControleMaterial(DataContainer dataContainer) {
	this.dataContainer = dataContainer;
    }

    @FXML
    protected void retorna() throws IOException {
	ControladorDeCena.trocarCena(new ControleMenu(dataContainer), "tela_menu_selecao.fxml");
    }

}
