/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto2so2;

import java.util.*;
/**
 *
 * @author rafik
 */
public class RoundRobin {
    
     int tempo = 0;
    int tempoMaximoEsperando = 0;
    int tempoTotalEsperando = 0;
    int trocaDeContexto = 0;
    int tempoDeEspera = 0;
    double  tempMedioOscioso = 0;
    int tempoTotalOscioso = 0;
     int tempoMedioEsperado =0;
  public void getOptimalExecutionOrder(int[][] jobs, float quantum) {
      
    Queue<int[]> queue = new LinkedList<>();

    List<Integer> executionOrder = new ArrayList<>();
   


    for (int[] job : jobs) {
      tempo = Math.max(tempo, job[0]);
      queue.add(job);
    }

    while (!queue.isEmpty()) {
      int[] job = queue.poll();
      if (job[1] <= quantum) {
        executionOrder.add(job[0]);
        tempo += job[1];
      }
      else {
        job[1] -= quantum;
        tempo += quantum;
        queue.add(job);
      }

       tempoDeEspera = tempo - job[0] - job[1];

      tempoMaximoEsperando = Math.max(tempoMaximoEsperando, tempoDeEspera);

      tempoTotalEsperando += tempoDeEspera;
      trocaDeContexto++;
    }

    int meanWaitingTime = tempoTotalEsperando / trocaDeContexto;

    int previousJobFinishTime = 0;
    for (int exe : executionOrder) {
      tempoTotalOscioso += exe - previousJobFinishTime;
      previousJobFinishTime = exe;
    }

   meanWaitingTime =  tempoTotalEsperando / trocaDeContexto;
     tempMedioOscioso = (double) tempoTotalOscioso / trocaDeContexto;
    
  }
}

