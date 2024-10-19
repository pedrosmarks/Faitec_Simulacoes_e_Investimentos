package br.com.faitec.sistemadeinvestimentos.material;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;

public class Material {

    // Realiza o download do arquivo PDF
    public static void fazerDownload(String fileName) throws IOException {
        // Caminho do arquivo na pasta de resouces
        String sourcePath = "src/main/resources/pdfs/" + fileName;
        File sourceFile = new File(sourcePath);

        // Verifica se o arquivo existe
        if (!sourceFile.exists()) {
            throw new IOException("Arquivo fonte não encontrado: " + sourcePath);
        }

        // Salva na pasta Downloads do usuário
        Path destinationPath = new File(System.getProperty("user.home") + "\\Downloads\\" + fileName).toPath();

        // Copia o arquivo para a pasta de destino
        Files.copy(sourceFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

        // Atualiza o horário de modificação para o horário atual
        Files.setLastModifiedTime(destinationPath, FileTime.fromMillis(System.currentTimeMillis()));
    }
}
