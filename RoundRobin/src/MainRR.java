
public class MainRR {
	public static void main(String[] args) {
        // Process IDs
        int process[] = {1, 2, 3};
        // Arrival time
        int arrivalTime[] = {0, 1, 2};
        // Burst time
        int burstTimeOfProcess[] = {20, 8, 6};
        int sizeOfProcess = process.length;
        int quantum_valueOfProcess = 2;
        RoundRobinScheduler.findavgTimeOfProcess(process, arrivalTime, sizeOfProcess, burstTimeOfProcess, quantum_valueOfProcess);
    }
}
