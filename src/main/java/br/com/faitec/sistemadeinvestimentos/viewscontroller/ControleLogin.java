package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.IOException;

import br.com.faitec.sistemadeinvestimentos.main.SistemaSimulacao;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleLogin {

    public static final String FXML_PATH = "tela_login.fxml";

    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoSenha;

    @FXML
    protected void onLoginClick() throws IOException {
	String usuario = campoUsuario.getText();
	String senha = campoSenha.getText();

	SistemaSimulacao.login(usuario, senha);
    }
}
