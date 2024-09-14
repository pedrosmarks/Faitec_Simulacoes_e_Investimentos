package br.com.faitec.sistemadeinvestimentos.main;



import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.viewscontroller.ControleLogin;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

import static br.com.faitec.sistemadeinvestimentos.material.Material.listarEPDFs;
import static br.com.faitec.sistemadeinvestimentos.simulacao.Investimento.simularInvestimento;
import static br.com.faitec.sistemadeinvestimentos.simulacao.Sonho.listarSonhos;

public class SistemaSimulacao extends Application {


    public static void main(String[] args) {
    launch();
    }

    private static void criarCadastro(Scanner scanner) {
        System.out.println("Entre com o seu nome de usuário: ");
        String usuario = scanner.nextLine();

        System.out.println("Entre com a sua senha: ");
        String senha = scanner.nextLine();

        // Armazenar usuário e senha em um arquivo de texto
        try (FileWriter fw = new FileWriter("usuarios.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("Usuário: " + usuario + ", Senha: " + senha);
            pw.flush(); // Garantir que os dados sejam gravados
            System.out.println("Cadastro realizado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public static void login(String usuario, String senha) throws IOException {
        /*System.out.println("Entre com o seu nome de usuário: ");
        String usuario = scanner.nextLine();

        System.out.println("Entre com a sua senha: ");
        String senha = scanner.nextLine();
        */
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
            System.out.println("Login bem-sucedido!");
            ControladorDeCena.trocarCena("tela_menu_selecao.fxml");
            mostrarMenu();
        } else {
            System.out.println("Nome de usuário ou senha incorretos.");
        }
    }


    public static void mostrarMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nMenu:");
            System.out.println("1. Fazer download de materiais");
            System.out.println("2. Simular investimento");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Fazendo download de materiais...");
                    // Código para fazer download de materiais
                    listarEPDFs();
                    break;
                case 2:
                    System.out.println("Simulando investimento...");
                    // Código para simular investimento
                    mostrarSubMenu(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void mostrarSubMenu(Scanner scanner) {
        System.out.println("\nSubmenu:");
        System.out.println("1. Simular um investimento");
        System.out.println("2. Realizar um sonho");
        System.out.print("Escolha uma opção: ");
        int subOpcao = scanner.nextInt();

        switch (subOpcao) {
            case 1:
                System.out.println("Simulando um investimento...");
                // código para simular um investimento
                simularInvestimento();
                break;
            case 2:
                // código para simular um sonho
                listarSonhos();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        ControladorDeCena.setSceneStage(stage);
        ControladorDeCena.trocarCena("tela-login.fxml");
        stage.setResizable(false);
        stage.show();
    }
}






