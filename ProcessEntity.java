
public class ProcessEntity  {
    int processID;
    String processName;
    int executionTime;
    int waitingTime;
    int turnaroundTime;
    ProcessEntity next;

    ProcessEntity(int pid, String name, int execTime) {
        this.processID = pid;
        this.processName = name;
        this.executionTime = execTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }

    void display() {
        System.out.printf("| %-10d | %-15s | %-13d | %-12d | %-15d |\n",
                processID, processName, executionTime, waitingTime, turnaroundTime);
    }
}
