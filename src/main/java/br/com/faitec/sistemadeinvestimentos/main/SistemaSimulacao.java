package br.com.faitec.sistemadeinvestimentos.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.viewscontroller.ControleLogin;
import javafx.application.Application;
import javafx.stage.Stage;

public class SistemaSimulacao extends Application {

    public static void main(String[] args) {
	launch();
    }

    public static void login(String usuario, String senha) throws IOException {

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
	    ControladorDeCena.trocarCena("tela_menu_selecao.fxml");
	} else {
	    System.out.println("Nome de usuário ou senha incorretos.");
	}
    }

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception {
	ControladorDeCena.setSceneStage(stage);
	ControladorDeCena.trocarCena(ControleLogin.FXML_PATH);
	stage.setResizable(false);
	stage.show();
    }
}
