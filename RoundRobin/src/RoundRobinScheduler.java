public class RoundRobinScheduler {
    // Method to calculate waiting time
    static void getWaitTime(int process[], int arrivalTime[], int sizeOfProcess, int burstTimes[], int weightOfProcess[], int quantum_value) {

        int temp_burstTime[] = new int[sizeOfProcess];
        for (int i = 0; i < sizeOfProcess; i++)
            temp_burstTime[i] = burstTimes[i];

        int currentTime = 0; // Current time
        int completed = 0; // To keep track of completed processes

        // Round Robin scheduling
        while (completed != sizeOfProcess) {
        	   	
            // Traverse all processes
            for (int i = 0; i < sizeOfProcess; i++) {
            	
                // If process has arrived and still needs processing
                if (temp_burstTime[i] > 0 && arrivalTime[i] <= currentTime) {
                	
                    if (temp_burstTime[i] > quantum_value) {
                        // Increment current time and decrement burst time
                        currentTime += quantum_value;
                        temp_burstTime[i] -= quantum_value;
                    } else {
                        // Increment current time and calculate waiting time
                        currentTime += temp_burstTime[i];
                        weightOfProcess[i] = currentTime - arrivalTime[i] - burstTimes[i];
                        temp_burstTime[i] = 0;
                        completed++; // Increment completed processes count
                    }
                }
            }
        }
    }

    // Method to calculate turnaround time
    static void findTurnAroundTime(int process[], int sizeOfProcess, int burstTimes[], int weightOfProcess[], int turnAroundTime[]) {
        // Turnaround time calculation
        for (int z = 0; z < sizeOfProcess; z++)
            turnAroundTime[z] = burstTimes[z] + weightOfProcess[z];
    }

    // Method to calculate average time
    static void findavgTimeOfProcess(int process[], int arrivalTime[], int sizeOfProcess, int burstTimes[], int quantum_value) {
        int weightOfProcess[] = new int[sizeOfProcess];
        int turnAroundTimeOfProcess[] = new int[sizeOfProcess];
        int totalWeight = 0;
        int turnAroundTime_total = 0;

        getWaitTime(process, arrivalTime, sizeOfProcess, burstTimes, weightOfProcess, quantum_value);

        // Turnaround time calculation
        findTurnAroundTime(process, sizeOfProcess, burstTimes, weightOfProcess, turnAroundTimeOfProcess);

        System.out.println("Process " + "  Burst Time  " + "  Waiting Time  " + "  Turnaround Time");

        // Total waiting time calculation
        for (int z = 0; z < sizeOfProcess; z++) {
            totalWeight += weightOfProcess[z];
            turnAroundTime_total += turnAroundTimeOfProcess[z];
            System.out.println(" " + (z + 1) + "   \t   " + burstTimes[z] + "  \t\t   " +
                    weightOfProcess[z] + "\t\t" + turnAroundTimeOfProcess[z]);
        }

        // Average waiting time and turnaround time
        System.out.println("Average waiting time --->  " + (float) totalWeight / (float) sizeOfProcess);
        System.out.println("Average turnaround time ---> " + (float) turnAroundTime_total / (float) sizeOfProcess);
    }
}