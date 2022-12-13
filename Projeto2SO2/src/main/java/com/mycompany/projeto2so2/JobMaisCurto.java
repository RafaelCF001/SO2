package com.mycompany.projeto2so2;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class JobMaisCurto {
     int tempo = 0;
  int tempoMaximo = 0;
  int maximoTempoEsperado = 0;
  int tempoTotalEsperado = 0;
  int trocaDeContexto = 0;
  int tempoTotalOscioso = 0;
  int tempoMedioOscioso = 0;
   int tempoMedioEspera = 0;
  public  void getOptimalExecutionOrder(int[][] jobs) {

      

 List<Integer> executionOrder = new ArrayList<>();

// calculate maximum time
int maxTime = 0;
for (int[] job : jobs) {
  maxTime += job[1];
}

// loop until maximum time
for (int i = 0; i < maxTime; i++) {
  for (int[] job : jobs) {
    if (job[0] <= i || tempo == 0) { // only add jobs that have arrived or when current time is 0
      int waitingTime = Math.max(0, tempo - job[1]);
      tempoTotalEsperado += waitingTime;
      maximoTempoEsperado = Math.max(maximoTempoEsperado, waitingTime);
      tempoTotalOscioso += Math.max(0, job[1] - tempo);

      tempo = Math.max(tempo, job[1]); // update current time

      executionOrder.add(job[0]);
      tempo += job[1]; // update current time after job execution
      tempoMaximo = Math.max(tempoMaximo, tempo);
      trocaDeContexto++;
    }
    else{
        tempo++;
    }
  }
}

tempoMedioOscioso = tempoTotalOscioso/ executionOrder.size();
tempoMedioEspera = tempoTotalEsperado/ executionOrder.size();

  }
}
