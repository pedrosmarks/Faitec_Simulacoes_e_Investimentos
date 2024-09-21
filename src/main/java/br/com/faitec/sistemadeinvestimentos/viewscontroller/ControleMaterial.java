package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import javafx.fxml.FXML;

import java.io.IOException;

public class ControleMaterial {
    public static final String FXML_PATH = "tela_download_materiais.fxml";

    @FXML
    protected void retorna() throws IOException{
        ControladorDeCena.trocarCena("tela_menu_selecao.fxml");
    }



}
