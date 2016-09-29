/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.Date;
import modelo.Problema;
import modelo.ProblemaDAO;


public class ProblemaControle {
    
    public static void receberFormularioCadastroProblema(String descricao, Date data){
        Problema objetoProblema = new Problema();
        
        objetoProblema.setData(data);
        objetoProblema.setDescricao(descricao);
        objetoProblema.setSituacao("ABERTO");
        objetoProblema.setCodigo(ProblemaDAO.contaObjetos()+1);
        ProblemaDAO.salvar(objetoProblema,"Problema.txt");
    }
    public static ArrayList<Problema> obterListaProblemas(String local){
        return ProblemaDAO.obterLista(local);
    }
    public static Problema obterProblemaPeloCodigo(int codigo){
        return  Problema.obterPeloCodigo(codigo);
    }
    
}
