package com.mycompany.projeto2so2;
import java.util.*;

public class PorPrioridades {
    int tempoMaximoEsperado = 0;
    int tempoTotalEsperado = 0;
    int trocaDeContexto = 0;
    int tempoOscioso = 0;
    double TempoMedioEsperando = 0;
    double tempoMedioOscioso =0;
    int tempo = 0;
    
  public void getOptimalExecutionOrder(int[][] jobs, float maintenanceTime) {
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

    List<Integer> executionOrder = new ArrayList<>();
   
    
        // é um for loop que adiciona um processo na fila e ordena por prioridade
    for (int[] job : jobs) {
      tempo = Math.max(tempo, job[0]);
      queue.add(job);
    }

    while (!queue.isEmpty()) {
      int[] job = queue.poll();
      int waitingTime = tempo - job[0];
      
      tempoMaximoEsperado = Math.max(tempoMaximoEsperado, waitingTime);
      tempoTotalEsperado += waitingTime;
      
      executionOrder.add(job[2]);
      
      tempo += maintenanceTime;
      trocaDeContexto++;
      tempoOscioso += job[0]  - maintenanceTime;
    }
    

     TempoMedioEsperando = (double) tempoTotalEsperado / tempo;
     tempoMedioOscioso = (double) tempoOscioso / tempo;

  }
}
