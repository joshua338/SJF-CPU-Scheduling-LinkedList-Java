
public class SJFScheduler {
    private ProcessPriorityQueue readyQueue;
    private int currentTime;

    public SJFScheduler() {
        readyQueue = new ProcessPriorityQueue();
        currentTime = 0;
    }

    public void addProcess(int pid, String name, int execTime) {
        ProcessEntity newProcess = new ProcessEntity(pid, name, execTime);
        readyQueue.enqueue(newProcess);
    }

    public void executeSJF() {
        if (readyQueue.isEmpty()) {
            System.out.println("\nNo processes to schedule!");
            return;
        }

        System.out.println("\n" + "═".repeat(100));
        System.out.println("                  SHORTEST JOB FIRST SCHEDULING EXECUTION                ");
        System.out.println("═".repeat(100));
        System.out.println("Starting SJF Scheduling at Time = 0ms");
        System.out.println("-".repeat(100));

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = readyQueue.getSize();

        System.out.println("\nExecution Order:");
        System.out.println("-".repeat(70));

        while (!readyQueue.isEmpty()) {
            ProcessEntity currentProcess = readyQueue.dequeue();


            currentProcess.waitingTime = currentTime;

            currentTime += currentProcess.executionTime;

            currentProcess.turnaroundTime = currentTime;

            totalWaitingTime += currentProcess.waitingTime;
            totalTurnaroundTime += currentProcess.turnaroundTime;

            System.out.printf("Time %3dms: Executing Process '%s' (ID: %d) for %dms\n",
                    currentProcess.waitingTime, currentProcess.processName,
                    currentProcess.processID, currentProcess.executionTime);
            System.out.printf("          → Waiting Time: %dms, Completion Time: %dms, Turnaround Time: %dms\n\n",
                    currentProcess.waitingTime, currentTime, currentProcess.turnaroundTime);
        }

        System.out.println("-".repeat(70));
        System.out.println("SCHEDULING COMPLETED!");
        System.out.println("-".repeat(70));
        System.out.printf("Total Execution Time: %d ms\n", currentTime);
        System.out.printf("Average Waiting Time: %.2f ms\n", (float) totalWaitingTime / processCount);
        System.out.printf("Average Turnaround Time: %.2f ms\n", (float) totalTurnaroundTime / processCount);
        System.out.println("═".repeat(100));
    }

    public void displayFinalResults() {
        System.out.println("\nNote: All processes have been executed. Run again to see new scheduling.");
    }


    public void showQueueStatus() {
        readyQueue.displayQueue();
    }
}
