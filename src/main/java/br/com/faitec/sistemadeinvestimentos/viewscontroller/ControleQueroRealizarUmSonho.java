package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.simulacao.Sonho;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ControleQueroRealizarUmSonho {
    public static final String FXML_PATH = "tela_quero_realizar_um_sonho.fxml";

    @FXML
    protected void retorna() throws IOException {
        ControladorDeCena.trocarCena("tela_escolha_simulacao.fxml");
    }


    @FXML
    private TextField valorQuePrecisa;

    @FXML
    private TextField valorInicial;

    @FXML
    private TextField valorMensal;


    @FXML
    protected void simular(){

        double valorQuePrecisaValue = Integer.parseInt(valorQuePrecisa.getText());
        double valorInicialvalue = Integer.parseInt(valorInicial.getText());
        double valorMensalvalue = Integer.parseInt(valorMensal.getText());

        Sonho.investimentos();

    }
}
