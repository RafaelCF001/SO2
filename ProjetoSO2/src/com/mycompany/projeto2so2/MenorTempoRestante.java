/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto2so2;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author rafik
 */
public class MenorTempoRestante {
    int tempo = 0;
  int tempoMaximo = 0;
  int tempoTotalEsperado = 0;
  int tempoMaximoEsperado = 0;
  int trocaDeContexto = 0;
  int tempoTotalOscioso = 0;
  double tempoMedioEsperado = 0;
  double tempoMedioOscioso = 0;
public void getOptimalExecutionOrder(int[][] jobs) {
    

    
  int tempo = jobs[0][1];
PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
List<Integer> executionOrder = new ArrayList<>();

for (int[] job : jobs) {
queue.add(job);
if (queue.peek()[1] < job[1]) {

queue.poll();
queue.add(job);
}
}

int i = 0;

while (!queue.isEmpty()) {
    
	int[] job = queue.poll();
	int waitTime = tempo - job[1];
	if(!queue.isEmpty()) {
	if(queue.peek()[1]< job[1]) {
		int[] cmp = queue.poll();
		queue.add(job);
		trocaDeContexto++;
		job = cmp;
	}
	}
	
	tempoTotalEsperado += waitTime;
	tempoMaximoEsperado = Math.max(tempoMaximoEsperado, waitTime);
	
	tempo += job[1];
	tempoMaximo = Math.max(tempoMaximo, tempo);
	tempoTotalOscioso += tempo - job[0];
	executionOrder.add(job[0]);
	
	i++;
}


tempoMedioEsperado = (double) tempoTotalEsperado / trocaDeContexto;
tempoMedioOscioso = (double) tempoTotalOscioso / trocaDeContexto;
}





}
