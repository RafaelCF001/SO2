import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SRTFScheduling {
  public static void main(String[] args) {
    // Define a matrix of processes with their arrival and burst times
    int[][] processes = {
        {0, 5},
        {1, 2},
        {2, 3},
        {3, 4}
    };

    // Create a list of Process objects from the matrix
    List<Process> processList = new ArrayList<>();
    for (int[] process : processes) {
      processList.add(new Process(process[0], process[1]));
    }

    // Sort the processes by their arrival time
    Collections.sort(processList, (p1, p2) -> p1.arrivalTime - p2.arrivalTime);

    // Simulate the SRTF scheduling algorithm
    int currentTime = 0;
    while (!processList.isEmpty()) {
      // Get the process with the shortest remaining time
      Process shortest = processList.get(0);
      for (Process process : processList) {
        if (process.arrivalTime <= currentTime && process.burstTime < shortest.burstTime) {
          shortest = process;
        }
      }

      // Remove the shortest process from the list
      processList.remove(shortest);

      // Increment the current time by the burst time of the shortest process
      currentTime += shortest.burstTime;

      // Print the completion time of
    }
  }
}