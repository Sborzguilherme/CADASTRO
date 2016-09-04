/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ProblemaControle;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import modelo.Problema;

/**
 *
 * @author Micro Solution
 */
public class ProblemaVisao {
    public static void exibeFormularioCadastroProblema() throws IOException{
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
            
            break;
        }catch(Exception e){
            System.out.println("Data invalida. Digite Novamente");
        }
        }while(true);
        
        ProblemaControle.receberFormularioCadastroProblema(descricao, data);
        MenuPrincipal.exibeMenu();
        
    }
    public static void exibirListaProblemas() throws IOException{
        System.out.println("--- LISTA DE PROBLEMAS REPORTADOS ---");
        System.out.println("CODIGO \t DESCRICAO \t SITUACAO \t DATA");

        ArrayList<Problema> lista = ProblemaControle.obterListaProblemas();
        
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for(int i=0; i<lista.size();i++){

            System.out.println(lista.get(i).getCodigo()+"\t"+lista.get(i).getDescricao()+"\t"+lista.get(i).getSituacao()+"\t"+sdf.format(lista.get(i).getData()));
        }
       System.out.println(" ");
       System.out.println("Digite M para voltar ao Menu");
       System.out.println("Digite o código do problema para mudar a situação para resolvido");
       
        Scanner entrada = new Scanner(System.in);
        String valorDigitado = entrada.nextLine();
        
        if(valorDigitado.equals("M")){
            MenuPrincipal.exibeMenu();
        }else{
            int op = Integer.parseInt(valorDigitado);
            Problema buscaCodigo = ProblemaControle.obterProblemaPeloCodigo(op);
            if(buscaCodigo == null){
                System.out.println("Codigo do problema não encontrado");
                MenuPrincipal.exibeMenu();
            }else{
                ProblemaControle.mudaSituacao(op);
                MenuPrincipal.exibeMenu();
            }
        }
    }
    
}
