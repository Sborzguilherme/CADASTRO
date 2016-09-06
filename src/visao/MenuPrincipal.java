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
        System.out.println("Digite S para Sair");
        
        Scanner entrada = new Scanner(System.in);
        char opcao = 0;
        
        do{
            
            opcao = entrada.nextLine().toUpperCase().charAt(0);
            System.out.println("OPCAO >> "+opcao);
            
            if(opcao != 'V' && opcao != 'R' && opcao !='S'){
                System.out.println("VALOR INVÁLIDO");
            }else { break;}
        
         }while(true);
         
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
