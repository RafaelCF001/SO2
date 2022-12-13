/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto2so2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author rafik
 */
public class Main {
    
     private int[][] matrixServico;
     private File f;
     
     public Main(String path){
         this.f = new File(path);
         this.matrixServico = new int[(int)f.length()][3];
     }    
     public void setLinhaMatrix(int tempo, int servico, int prioridade, int linha){
         this.matrixServico[linha][0] = tempo;
         this.matrixServico[linha][1] = servico;
         this.matrixServico[linha][2] = prioridade; 
     }
     
    public  int[][] gerarArquivo(int opcao, String path) throws FileNotFoundException, InterruptedException {

        Scanner scan = new Scanner(this.f);
        int i = 0;

        while(scan.hasNext()){
            String gerador = scan.next();
            String[] stringSplit = gerador.trim().split(","); // pos 0 tempo de chegada, 1 tempo de servico, 2 prioridade
             setLinhaMatrix(Integer.parseInt(stringSplit[0]),Integer.parseInt(stringSplit[1]),Integer.parseInt(stringSplit[2]), i);
             i++;
         }
       
        return this.matrixServico;
    }
}
