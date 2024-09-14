package br.com.faitec.sistemadeinvestimentos.material;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Material {

    public static void listarEPDFs() {
        String pathName = "src\\main\\resources\\pdfs";
        File pasta = new File(pathName); //  caminho da sua pasta
        File[] arquivos = pasta.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

        Scanner scanner = new Scanner(System.in);

        if (arquivos != null && arquivos.length > 0) {
            System.out.println("Arquivos PDF disponíveis:");
            for (int i = 0; i < arquivos.length; i++) {
                System.out.println((i + 1) + ". " + arquivos[i].getName());
            }

            System.out.print("Escolha um arquivo para download: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (escolha > 0 && escolha <= arquivos.length) {
                fazerDownload(arquivos[escolha - 1]);
            } else {
                System.out.println("Escolha inválida.");
            }
        } else {
            System.out.println("Nenhum arquivo PDF encontrado na pasta.");
        }
    }

    public static void fazerDownload(File arquivo) {
        Path destino = new File("D:\\" + arquivo.getName()).toPath(); // Substitua pelo caminho de destino
        try {
            Files.copy(arquivo.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Download concluído: " + destino);
        } catch (IOException e) {
            System.out.println("Erro ao fazer download do arquivo: " + e.getMessage());
        }
    }

}
