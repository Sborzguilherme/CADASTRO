/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Micro Solution
 */
public class MenuPrincipal implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    public void abrirTelaCadastroProblema(ActionEvent e) throws IOException{
        
        Button quemFoi =(Button) e.getSource();
        Scene cenaAtual = quemFoi.getScene();
        Stage palcoAtual =(Stage) cenaAtual.getWindow();

        Pane elementoPrincipalDoNovoPalco = FXMLLoader.load(getClass().getResource("ProblemaCadastro.fxml"));
        Scene novaCena = new Scene(elementoPrincipalDoNovoPalco);
        palcoAtual.setScene(novaCena);
        palcoAtual.show();
    
    }
    
    public void abrirListaProblemas(ActionEvent e) throws IOException{
        Button quemFoi =(Button) e.getSource();
        Scene cenaAtual = quemFoi.getScene();
        Stage palcoAtual =(Stage) cenaAtual.getWindow();

        Pane elementoPrincipalDoNovoPalco = FXMLLoader.load(getClass().getResource("ListaProblemas.fxml"));
        Scene novaCena = new Scene(elementoPrincipalDoNovoPalco);
        palcoAtual.setScene(novaCena);
        palcoAtual.show();
    
    
    }
    
    public void alterarSituacaoProblema(ActionEvent e) throws IOException{
        Button quemFoi =(Button) e.getSource();
        Scene cenaAtual = quemFoi.getScene();
        Stage palcoAtual =(Stage) cenaAtual.getWindow();

        Pane elementoPrincipalDoNovoPalco = FXMLLoader.load(getClass().getResource("AlteraSituacaoProblema.fxml"));
        Scene novaCena = new Scene(elementoPrincipalDoNovoPalco);
        palcoAtual.setScene(novaCena);
        palcoAtual.show();
    
    }
}
