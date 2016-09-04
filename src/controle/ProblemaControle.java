/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import armazenamento.MeioArmazenamento;
import java.util.ArrayList;
import java.util.Date;
import modelo.Problema;


public class ProblemaControle {
    
    public static void receberFormularioCadastroProblema(String descricao, Date data){
        Problema objetoProblema = new Problema();
        
        objetoProblema.setData(data);
        objetoProblema.setDescricao(descricao);
        objetoProblema.setSituacao("ABERTO   ");
        objetoProblema.setCodigo(MeioArmazenamento.LISTA_DE_PROBLEMAS.size()+1);
        objetoProblema.salvar();
    }
    public static ArrayList<Problema> obterListaProblemas(){
        return Problema.obterLista();
    }
    public static Problema obterProblemaPeloCodigo(int codigo){
        return  Problema.obterPeloCodigo(codigo);
    }
    public static void mudaSituacao(int op){
        Problema.obterPeloCodigo(op).setSituacao("RESOLVIDO");
    }
}
