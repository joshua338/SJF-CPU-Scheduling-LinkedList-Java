public class ProcessPriorityQueue {
    private ProcessEntity front;
    private int size;

    public ProcessPriorityQueue() {
        front = null;
        size = 0;
    }


    public void enqueue(ProcessEntity process) {

        if (front == null || process.executionTime < front.executionTime) {
            process.next = front;
            front = process;
        } else {

            ProcessEntity current = front;
            while (current.next != null && current.next.executionTime <= process.executionTime) {
                current = current.next;
            }
            process.next = current.next;
            current.next = process;
        }
        size++;
        System.out.println("✓ Process '" + process.processName + "' (ID: " + process.processID +
                ") added to queue with execution time: " + process.executionTime + "ms");
    }


    public ProcessEntity dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        ProcessEntity temp = front;
        front = front.next;
        size--;
        return temp;
    }


    public ProcessEntity peek() {
        return front;
    }


    public boolean isEmpty() {
        return front == null;
    }


    public int getSize() {
        return size;
    }


    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("\nQueue is empty!");
            return;
        }

        System.out.println("\n" + "=".repeat(85));
        System.out.println("CURRENT PROCESS QUEUE (Sorted by Execution Time - Shortest Job First)");
        System.out.println("=".repeat(85));
        System.out.println("| Process ID | Process Name    | Execution Time | Waiting Time | Turnaround Time |");
        System.out.println("-".repeat(85));

        ProcessEntity current = front;
        int position = 1;
        while (current != null) {
            System.out.printf("| %-10d | %-15s | %-13d ms | %-12d ms | %-15d ms |\n",
                    current.processID, current.processName, current.executionTime,
                    current.waitingTime, current.turnaroundTime);
            current = current.next;
            position++;
        }
        System.out.println("=".repeat(85));
        System.out.println("Total processes in queue: " + size);
    }
}

