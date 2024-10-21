package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.material.Material;
import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert;

public class ControleMaterial {
    public static final String FXML_PATH = "tela_download_materiais.fxml";

    private DataContainer dataContainer;

    @FXML
    private Hyperlink downloadLink, downloadLink2, downloadLink3, downloadLink4, downloadLink5;
    @FXML
    private Hyperlink downloadLink6, downloadLink7, downloadLink8, downloadLink9, downloadLink10;
    @FXML
    private Hyperlink downloadLink11;

    private Map<Hyperlink, String> downloadLinksMap = new LinkedHashMap<>();

    public ControleMaterial(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    @FXML
    protected void retorna() throws IOException {
        ControladorDeCena.trocarCena(new ControleMenu(dataContainer), "tela_menu_selecao.fxml");
    }

    @FXML
    private void initialize() {
        // Mapeia os links aos arquivos correspondentes
        downloadLinksMap.put(downloadLink, "1- Introdução ao mundo de investimentos.pdf");
        downloadLinksMap.put(downloadLink2, "2- O que são Juros - Conceitos Básicos e Tipos de Juros.pdf");
        downloadLinksMap.put(downloadLink3, "3- A Taxa Selic - O que é - E Como Afeta a Economia.pdf");
        downloadLinksMap.put(downloadLink4, "4- Investimentos em Renda Fixa - Tesouro Direto, CDB, LCI e LCA.pdf");
        downloadLinksMap.put(downloadLink5, "5- Fundos de Investimento - Tipos, Funcionamento e Vantagens.pdf");
        downloadLinksMap.put(downloadLink6, "6- Investimentos em Ações.pdf");
        downloadLinksMap.put(downloadLink7, "7- Análise Fundamentalista vs. Análise Técnica - Métodos de Avaliação de Investimentos.pdf");
        downloadLinksMap.put(downloadLink8, "8- Diversificação de Portfólio - Importância e Estratégias.pdf");
        downloadLinksMap.put(downloadLink9, "9- O Papel da Inflação nos Investimentos - E Como Protegê-los.pdf");
        downloadLinksMap.put(downloadLink10, "10- Planejamento Financeiro.pdf");
        downloadLinksMap.put(downloadLink11, "11- Referências.pdf");

        // Associa a ação a todos os links mapeados
        for (Map.Entry<Hyperlink, String> entry : downloadLinksMap.entrySet()) {
            Hyperlink link = entry.getKey();
            String pdfFileName = entry.getValue();
            link.setOnAction(event -> handleDownload(pdfFileName));
        }
    }

    @FXML
    private void handleDownloadAction(ActionEvent event) {
        String pdfFileName = "arquivo_exemplo.pdf";  // Nome do arquivo a ser baixado
        handleDownload(pdfFileName);
    }

    private void handleDownload(String pdfFileName) {
        try {
            // Tenta fazer o download do arquivo
            Material.fazerDownload(pdfFileName);

            // Se o download for bem-sucedido, exibe o alerta de sucesso
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Download Concluído");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Download Concluído com sucesso na pasta 'Downloads' ");
            successAlert.showAndWait();

        } catch (IOException e) {
            // Se houver uma falha, exibe o alerta de erro
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erro no Download");
            errorAlert.setHeaderText("Falha ao baixar o arquivo");
            errorAlert.setContentText(pdfFileName);
            errorAlert.showAndWait();
        }
    }
}