/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ProblemaControle;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Problema;
import modelo.ProblemaDAO;
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
        
            Button quemFoi =(Button) e.getSource();
            Scene cenaAtual = quemFoi.getScene();
            Stage palcoAtual =(Stage) cenaAtual.getWindow();

            Pane elementoPrincipalDoNovoPalco = FXMLLoader.load(getClass().getResource("MenuTelaProblema.fxml"));
            Scene novaCena = new Scene(elementoPrincipalDoNovoPalco);
            palcoAtual.setScene(novaCena);
            palcoAtual.show();
        }
    
    }
    
    public static void exibeFormularioCadastroProblema() throws IOException, ParseException{
        String descricao;
        Date data;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("--- REPORTE DE  NOVOS PROBLEMAS ---");
        System.out.println("Digite a descrição do Problema");        
        descricao = entrada.nextLine();
            
        System.out.println("Digite a data em que o problema foi reportado");
        
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        formatadorData.setLenient(false);
        do{
        try{
            data = formatadorData.parse(entrada.nextLine());   
            if(data.before(new Date())){
                 break;
            }else{
                System.out.println("Data Inválida! Digite Novamente");
            }
           
        }catch(Exception e){
            System.out.println("Data invalida. Digite Novamente");
        }
        }while(true);
        
        ProblemaControle.receberFormularioCadastroProblema(descricao, data);
        //MenuPrincipal.exibeMenu();
        
    }
    public static void exibirListaProblemas() throws IOException, ParseException{
        System.out.println("--- LISTA DE PROBLEMAS REPORTADOS ---");
        System.out.println("CODIGO \t DESCRICAO \t SITUACAO \t DATA");

        ArrayList<Problema> lista = ProblemaControle.obterListaProblemas("Problema.txt");
        
        //Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for(int i=0; i<lista.size();i++){
            System.out.println(lista.get(i).getCodigo()+"\t"+lista.get(i).getDescricao()+"\t"+lista.get(i).getSituacao()+"\t"+sdf.format(lista.get(i).getData()));
        }
       System.out.println(" ");
       System.out.println("Digite 0 para voltar ao Menu");
       System.out.println("Digite o código do problema para mudar a situação para resolvido");
       
        Scanner entrada = new Scanner(System.in);
        int valorDigitado = 0;
        do{
        int teste=0;
            do{
                try{
                    valorDigitado = Integer.parseInt(entrada.nextLine());
                    teste =1;
                }catch(Exception e){
                    System.out.println("Não foi possível converter para inteiro");
                }
            }while(teste ==0);
        
        if(valorDigitado == 0){
            //MenuPrincipal.exibeMenu();
        }else{
            
            ProblemaDAO.mudaSituacao(valorDigitado);
            //MenuPrincipal.exibeMenu();
//            Problema buscaCodigo = ProblemaControle.obterProblemaPeloCodigo(valorDigitado);
//            if(buscaCodigo != null){
//                ProblemaDAO.mudaSituacao(valorDigitado);
//                MenuPrincipal.exibeMenu();
//            }else{
//                System.out.println("Codigo do problema não encontrado");
//            }
        }
        }while(true);
    
    }

   
}

    

