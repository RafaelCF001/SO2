/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto2so2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
/**
 *
 * @author rafik
 */
public class Fcfs {
     int tempoEspera = 0;
     int processado = 0;
     int tempoMax = 0;
     int totalProcessos = 0;
     int tempoTotalOscioso = 0;
     int MaxTempoEspera = 0;
     float mediaTempoEspera = 0;
     float mediaTempoOscioso = 0;
    public void fcfs(int matrix[][]) throws InterruptedException {
       
        ArrayList<Integer> tempoDeChegada = new ArrayList<>();
        ArrayList<Integer> tempos = new ArrayList<>();
        int somaTempo = 0;
         tempoEspera = 0;
         processado = 0;
         tempoMax = 0;
         totalProcessos = 0;
         tempoTotalOscioso = 0;
         MaxTempoEspera = 0;
         mediaTempoEspera = 0;
         mediaTempoOscioso = 0;
        
        for(int i = 0; i<matrix.length;i++){
            
            tempoDeChegada.add(matrix[i][0]);
            tempos.add(matrix[i][1]);
            somaTempo += matrix[i][1];
            totalProcessos++;
        }
        
        for(int i = 0; i< somaTempo; i++){
            //tempo ocisio
            int tempoCmp = (int) (i - matrix[processado][0]);
            
            if(tempoCmp>tempoMax){
                tempoMax = tempoCmp;
            }
            //verifica o tempo de chegada e se foi processado
            if(i >= tempoDeChegada.get(processado) &&matrix[processado][1] != 0 ){
                
                matrix[processado][1]--;
                
                if(matrix[processado][1] == 0){ // assim que termina o processamento incrementa variavel para o próximo 
                    processado++;
                    mediaTempoEspera += tempoCmp;
                    if (tempoCmp > MaxTempoEspera) {
                        MaxTempoEspera = tempoCmp;
                    }
                }
            }
            else{
            //caso não cai no if, é um tempo ocioso da cpu 
                tempoEspera++;
                tempoTotalOscioso++;
            }
        }
        mediaTempoEspera = mediaTempoEspera / totalProcessos;
        mediaTempoOscioso = (float) tempoTotalOscioso / somaTempo;
        
      
    }

}