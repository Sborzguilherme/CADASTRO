/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import armazenamento.MeioArmazenamento;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Micro Solution
 */
public class Problema {
   
    private String descricao;
    private String situacao;
    private Date data;
    private int codigo;

     /**
     * @return the descricao
     */
    @Override
    public String toString() {
        return this.descricao+" - "+this.situacao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }
    
//    public void salvar(){
//        MeioArmazenamento.LISTA_DE_PROBLEMAS.add(this);
//    }
//    public static ArrayList<Problema> obterLista(){
//        return MeioArmazenamento.LISTA_DE_PROBLEMAS;
//    }
    public static Problema obterPeloCodigo(int codigo){
        for(Problema obj : ProblemaDAO.obterLista("Auxiliar.txt")){
            if(obj.getCodigo() == codigo){
                return obj;
            }
        }
        return null;
    }
    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }    
}
