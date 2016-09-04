/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Micro Solution
 */
public class MenuPrincipal {
    public static void exibeMenu() throws IOException {
        do{   
        System.out.println("= = = MENU PRINCIPAL = = =");
        System.out.println("Digite V para visualizar os problemas reportados");
        System.out.println("Digite R para reportar um novo problema");
        System.out.println("Outro valor para Sair");
        
        Scanner entrada = new Scanner(System.in);
        char opcao = 0;
        
         try{
            opcao = entrada.nextLine().toUpperCase().charAt(0);
            System.out.println("OPCAO >> "+opcao);
         }catch(Exception e){
             System.out.println("Digite um valor valido");
         }
         
         if(opcao == 'V'){
             ProblemaVisao.exibirListaProblemas();
         }
         if(opcao == 'R'){
             ProblemaVisao.exibeFormularioCadastroProblema();
         }else{
             System.exit(0);
         }
        }while(true);
    }
}
