package br.com.faitec.sistemadeinvestimentos.main;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import br.com.faitec.sistemadeinvestimentos.viewscontroller.ControleLogin;
import javafx.application.Application;
import javafx.stage.Stage;

public class SistemaSimulacao extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception {
        ControladorDeCena.setSceneStage(stage);
        ControladorDeCena.trocarCena(new ControleLogin(new DataContainer()), ControleLogin.FXML_PATH);
        stage.setResizable(false);
        stage.show();
    }
}
