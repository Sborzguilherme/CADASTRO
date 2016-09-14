/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Micro Solution
 */
public class ProblemaDAO {
    public static ArrayList<Problema> obterLista(){ //   REPETIÇÃO METODO obterListaArquivos
        //return MeioArmazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS;
        ArrayList<Problema> retorno = new ArrayList<>();
        try{
            
            Path caminhoArquivo = Paths.get("Problema.txt");
            if(caminhoArquivo.toFile().exists()){
                for(String linhaAtual : Files.readAllLines(caminhoArquivo)){
                String[] dado = linhaAtual.split(";");
                Problema objeto = new Problema();
                SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
                objeto.setCodigo(Integer.parseInt(dado[0]));
                objeto.setDescricao(dado[1]);
                objeto.setData(formatadorData.parse(dado[2]));
                objeto.setSituacao(dado[3]);
                
                retorno.add(objeto);
            }
            
            }

            }catch(Exception e){ // NECESSARIO MUDAR POR CAUSA DA TRANSFORMAÇÃO DA DATA
                Logger.getLogger(Problema.class.getName()).log(Level.SEVERE, null, e);
            }
        return retorno;
        
    }
    public static void salvar(Problema paraSalvar, String situacao){
        //MeioArmazenamento.MEIO_ARMAZENAMENTO_EQUIPAMENTOS.add(this);
        try{
            Path caminhoArquivo = Paths.get("Problema.txt");
            //String separadorLinha = System.getProperty("Line.separator");
            String linhaEquip;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            linhaEquip =(paraSalvar.getCodigo()+";"+paraSalvar.getDescricao()+";"+sdf.format(paraSalvar.getData())+";"+situacao)+"\r\n";
            Files.write(caminhoArquivo, linhaEquip.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        
        }catch(Exception e){
            
        }
    }
    
   public void copy(File s, File t) throws IOException {
      FileChannel in = (new FileInputStream(s)).getChannel();
      FileChannel out = (new FileOutputStream(t)).getChannel();
      in.transferTo(0, s.length(), out);
      in.close();
      out.close();
}

    
public static int contaObjetos(){
        int contador =0;
        try{
            Path caminhoArquivo = Paths.get("Problema.txt");
            if(caminhoArquivo.toFile().exists()){
                for(String linhaAtual : Files.readAllLines(caminhoArquivo)){
                    contador++;
                }
            }
        }catch(Exception e){
            Logger.getLogger(Problema.class.getName()).log(Level.SEVERE, null, e);
        }
        return contador;
    }
public static void mudaSituacao(int op) throws IOException{
    
    String arquivo = "Problema.txt";
    String arquivoTmp = "Auxiliar.txt";

    BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
    BufferedReader reader = new BufferedReader(new FileReader(arquivo));
    
    
    Problema p = Problema.obterPeloCodigo(op);
    ProblemaDAO.salvar(p,"RESOLVIDO");
    
    
//    String aux = Integer.toString(op);
//    Path caminhoArquivo = Paths.get("Problema.txt");
//    for(String linhaAtual : Files.readAllLines(caminhoArquivo)){
//            String[] dado = linhaAtual.split(";");
//            if(linhaAtual.contains(aux)){
//                linhaAtual.replace("ABERTO","RESOLVIDO");
//            }
//    }
    
//    while ((linha = reader.readLine()) != null) {
//        String dados = linha.split(";")
//        if(linha2[0].contains(aux)){
//            linha.replace("ABERTO","RESOLVIDO");
//        }
//        
//    }
    
    writer.close();        
    //reader.close();

    new File(arquivo).delete();
    new File(arquivoTmp).renameTo(new File(arquivo));
    }
}
