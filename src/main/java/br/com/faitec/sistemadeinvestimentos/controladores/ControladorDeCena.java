package br.com.faitec.sistemadeinvestimentos.controladores;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorDeCena {
    private static Stage stage;


    public static void setSceneStage(Stage stage){
        ControladorDeCena.stage = stage;
    }

    public static void trocarCena(String fxmlPath) throws IOException {

        FXMLLoader loader = new FXMLLoader(ControladorDeCena.class.getResource("/br.com.faitec.sistemadeinvestimentos/" + fxmlPath));
        Parent root = loader.load();
        stage.setTitle("Sistema de estudos e simulação de investimentos");
        stage.setMinWidth(960);
        stage.setMinHeight(540);
        stage.setScene(new Scene(root));
    }
}

