package br.com.faitec.sistemadeinvestimentos.viewscontroller;

import java.io.IOException;
import java.util.ArrayList;

import br.com.faitec.sistemadeinvestimentos.controladores.ControladorDeCena;
import br.com.faitec.sistemadeinvestimentos.simulacao.DataContainer;
import br.com.faitec.sistemadeinvestimentos.simulacao.ResultadoSonho;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControleResultadoSonho {
    public static final String FXML_PATH = "tela_resultado_quero_realizar_um_sonho.fxml";

    private DataContainer dataContainer;
    private ArrayList<ResultadoSonho> resultadoSonhos;
    private ObservableList<ResultadoSonho> resultadoSonhosObservable;

    @FXML
    TableView<ResultadoSonho> tabelaResultadoSonho;

    @FXML
    TableColumn<ResultadoSonho, String> investimento;

    @FXML
    TableColumn<ResultadoSonho, String> tempoNecessario;

    @FXML
    TableColumn<ResultadoSonho, String> risco;

    @FXML
    TableColumn<ResultadoSonho, String> ganhos;

    public ControleResultadoSonho(DataContainer dataContainer)
    {
        this.dataContainer = dataContainer;
    }

    @FXML
    protected void retorna() throws IOException {
        ControladorDeCena.trocarCena(new ControleQueroRealizarUmSonho(dataContainer),
                ControleQueroRealizarUmSonho.FXML_PATH);
    }

    @FXML
    public void initialize() {
        resultadoSonhos = dataContainer.getResultadoSonhos();

        investimento.setCellValueFactory(new PropertyValueFactory<>("investimento"));
        tempoNecessario.setCellValueFactory(new PropertyValueFactory<>("tempoNecessario"));
        risco.setCellValueFactory(new PropertyValueFactory<>("risco"));
        ganhos.setCellValueFactory(new PropertyValueFactory<>("ganhos"));

        resultadoSonhosObservable = FXCollections.observableArrayList(resultadoSonhos);

        tabelaResultadoSonho.setItems(resultadoSonhosObservable);
    }
}
