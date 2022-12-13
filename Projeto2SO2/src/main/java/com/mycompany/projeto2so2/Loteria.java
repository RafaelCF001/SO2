package com.mycompany.projeto2so2;
import java.util.*;
public class Loteria {
    
  // Add variables to keep track of statistics
   int tempoMaximo = 0;
   int tempoMaximoEspera = 0;
   int tempoTotalEsperando = 0;
   int trocaDeContexto = 0;
   int tempoTotalOscioso = 0;
   int tempoMedioEsperando = 0;
   int tempoOscioso = 0;
    int time = 0;
    int tempoMedioOscioco = 0;
  public void getOptimalExecutionOrder(int[][] jobs) {
    Map<Integer, Integer> ticketMap = new HashMap<>();
    List<Integer> executionOrder = new ArrayList<>();
    
    for (int i = 0; i < jobs.length; i++) {
      ticketMap.put(jobs[i][0], jobs[i][2]);
    }

    
    Random random = new Random();

    for (int[] job : jobs) {
      int waitTime = time - job[0];
      tempoTotalEsperando += waitTime;

      tempoMaximoEspera = Math.max(tempoMaximoEspera, waitTime);

      if (time < job[0]) {
        tempoOscioso += job[0] - time;
        time = job[0];
      }
      executionOrder.add(job[2]);
      time += job[1];

      int totalTickets = ticketMap.values().stream().mapToInt(Integer::intValue).sum();
      int targetTickets = random.nextInt(totalTickets);
      int currentTickets = 0;
      for (int jid : ticketMap.keySet()) {
        currentTickets += ticketMap.get(jid);
        if (currentTickets >= targetTickets) {
          executionOrder.add(jid);
          trocaDeContexto++;
          break;
        }
      }

      tempoMaximo = Math.max(tempoMaximo, time);
      tempoTotalOscioso += tempoOscioso;
    }

    tempoMedioOscioco = tempoTotalOscioso/ tempoMaximo;
    tempoMedioEsperando = tempoTotalEsperando / trocaDeContexto;
 }
}

