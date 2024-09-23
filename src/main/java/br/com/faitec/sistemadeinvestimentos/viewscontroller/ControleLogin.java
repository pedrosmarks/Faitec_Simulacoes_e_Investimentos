package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleLogin {

    public static final String FXML_PATH = "tela_login.fxml";

    private DataContainer dataContainer;

    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoSenha;

    public ControleLogin(DataContainer dataContainer) {
	this.dataContainer = dataContainer;
    }

    @FXML
    protected void onLoginClick() throws IOException {
	String usuario = campoUsuario.getText();
	String senha = campoSenha.getText();

	login(usuario, senha, dataContainer);
    }

    public static void login(String usuario, String senha, DataContainer dataContainer) throws IOException {

	boolean loginBemSucedido = false;

	try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
	    String linha;
	    while ((linha = br.readLine()) != null) {
		String[] partes = linha.split(", ");
		String usuarioArmazenado = partes[0].split(": ")[1];
		String senhaArmazenada = partes[1].split(": ")[1];

		if (usuario.equals(usuarioArmazenado) && senha.equals(senhaArmazenada)) {
		    loginBemSucedido = true;
		    break;
		}
	    }
	} catch (IOException e) {
	    System.out.println("Erro ao ler os dados: " + e.getMessage());
	}

	if (loginBemSucedido) {
	    ControladorDeCena.trocarCena(new ControleMenu(dataContainer), ControleMenu.FXML_PATH);
	} else {
	    System.out.println("Nome de usuário ou senha incorretos.");
	}
    }
}
