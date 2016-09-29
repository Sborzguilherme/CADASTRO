/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import modelo.Problema;
import modelo.ProblemaDAO;

/**
 *
 * @author Micro Solution
 */
public class ApresentaçãoLista implements Initializable  {

    @FXML
    private TableView<Problema> tabela;
    @FXML
    private TableColumn<Problema, String> colDescricao;
    @FXML
    private TableColumn<Problema, String> colSituacao;
    @FXML
    private TableColumn<Problema, Date> colData;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        colSituacao.setCellValueFactory(new PropertyValueFactory("situacao"));
        colData.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Problema, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(TableColumn.CellDataFeatures<Problema, Date> p) {
                return new SimpleObjectProperty<>(p.getValue().getData());
            }
        });
     
        ObservableList<Problema> problemas = FXCollections.observableArrayList(ProblemaDAO.obterLista("Problema.txt"));
        tabela.setItems(problemas);
    }    
    
    public void onClickVoltar(ActionEvent event) throws IOException{
        Button botaoQueClicou = (Button) event.getSource();
        Stage palco = (Stage) botaoQueClicou.getScene().getWindow();
        Pane principal = FXMLLoader.load(getClass().getResource("MenuTelaProblema.fxml"));
        Scene novaCena = new Scene(principal);
        palco.setScene(novaCena);
        palco.show();
    }
    
}
