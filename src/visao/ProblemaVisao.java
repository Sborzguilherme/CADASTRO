/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ProblemaControle;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 *
 */
public class ProblemaVisao implements Initializable {
   
    @FXML
    private TextField txtDescricaoProblema;
    @FXML
    private DatePicker dataProblemaReportado;  
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
   
    public void onClickSalvar(ActionEvent e) throws IOException{
        String descricao = txtDescricaoProblema.getText();
        
        LocalDate manutencaoLocal = dataProblemaReportado.getValue();
        Instant instante = Instant.from(manutencaoLocal.atStartOfDay(ZoneId.systemDefault()));
        Date dataProblema = Date.from(instante);
        
        if(dataProblema.after(new Date())){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ERRO");
            alerta.setContentText("Impossível reportar um problema que ainda não aconteceu");
            alerta.showAndWait();
        }else{
            ProblemaControle.receberFormularioCadastroProblema(descricao, dataProblema);
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("PARABÉNS");
            alerta.setContentText("Equipamento Cadastrado com sucesso");
            alerta.showAndWait();
            
        }
    
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

    

