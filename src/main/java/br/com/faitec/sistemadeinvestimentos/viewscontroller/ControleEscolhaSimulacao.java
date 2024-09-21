package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class ControleEscolhaSimulacao {
    public static final String FXML_PATH = "tela_escolha_simulacao.fxml";

    @FXML
    protected void simulaInvestimento() throws IOException{
        ControladorDeCena.trocarCena("tela_quero_simular_um_investimento.fxml");
    }

    @FXML
    protected void simulaSonho() throws IOException{
        ControladorDeCena.trocarCena("tela_quero_realizar_um_sonho.fxml");
    }


    @FXML
    protected void retorna() throws IOException {
        ControladorDeCena.trocarCena("tela_menu_selecao.fxml");

    }






    }

