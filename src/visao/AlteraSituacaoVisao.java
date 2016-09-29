/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Problema;
import modelo.ProblemaDAO;

/**
 *
 * @author 5927951
 */
public class AlteraSituacaoVisao implements Initializable{
    @FXML
    private ComboBox<Problema> txtListaProblemas;
    private ObservableList<Problema> listaProblemasDados = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(int i=0; i< ProblemaDAO.obterListaAbertos("Problema.txt").size();i++){
            listaProblemasDados.add(ProblemaDAO.obterListaAbertos("Problema.txt").get(i));
        }
        txtListaProblemas.setItems(listaProblemasDados);
    }
    
    public void voltaMenu(ActionEvent e) throws IOException{
    
        Button quemFoi =(Button) e.getSource();
        Scene cenaAtual = quemFoi.getScene();
        Stage palcoAtual =(Stage) cenaAtual.getWindow();
        
        // RETORNO AO MENU
        Pane elementoPrincipalDoNovoPalco = FXMLLoader.load(getClass().getResource("MenuTelaProblema.fxml"));
        Scene novaCena = new Scene(elementoPrincipalDoNovoPalco);
        palcoAtual.setScene(novaCena);
        palcoAtual.show();
    }
    public void onClickSalvar(ActionEvent e) throws IOException{
    
        int opcao = txtListaProblemas.getValue().getCodigo();
        ProblemaDAO.mudaSituacao(opcao);
        
        Button quemFoi =(Button) e.getSource();
        Scene cenaAtual = quemFoi.getScene();
        Stage palcoAtual =(Stage) cenaAtual.getWindow();

        Pane elementoPrincipalDoNovoPalco = FXMLLoader.load(getClass().getResource("MenuTelaProblema.fxml"));
        Scene novaCena = new Scene(elementoPrincipalDoNovoPalco);
        palcoAtual.setScene(novaCena);
        palcoAtual.show();
    }
    
}
