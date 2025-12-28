import java.util.*;
public class SJFProcessScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SJFScheduler scheduler = new SJFScheduler();
        int choice;


        do {
            System.out.println("\n" + "=".repeat(70));
            System.out.println("MAIN MENU");
            System.out.println("=".repeat(70));
            System.out.println("1. Add a Process");
            System.out.println("2. Add Multiple Processes (Batch Input)");
            System.out.println("3. View Current Process Queue");
            System.out.println("4. Execute Shortest Job First Scheduling");
            System.out.println("5. Run Sample Test Case");
            System.out.println("6. Exit");
            System.out.println("=".repeat(70));
            System.out.print("Enter your choice (1-6): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n" + "-".repeat(50));
                    System.out.println("ADD NEW PROCESS");
                    System.out.println("-".repeat(50));

                    System.out.print("Enter Process ID: ");
                    int pid = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Process Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Execution Time (ms): ");
                    int execTime = scanner.nextInt();

                    scheduler.addProcess(pid, name, execTime);
                    break;

                case 2:
                    System.out.println("\n" + "-".repeat(50));
                    System.out.println("BATCH PROCESS INPUT");
                    System.out.println("-".repeat(50));

                    System.out.print("How many processes to add? ");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    for (int i = 1; i <= count; i++) {
                        System.out.println("\nProcess #" + i + ":");
                        System.out.print("  Process ID: ");
                        int batchPid = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("  Process Name: ");
                        String batchName = scanner.nextLine();

                        System.out.print("  Execution Time (ms): ");
                        int batchExecTime = scanner.nextInt();
                        scanner.nextLine();

                        scheduler.addProcess(batchPid, batchName, batchExecTime);
                    }
                    System.out.println("\n✓ Successfully added " + count + " processes!");
                    break;

                case 3:
                    scheduler.showQueueStatus();
                    break;

                case 4:
                    scheduler.executeSJF();
                    break;

                case 5:
                    runSampleTestCase(scheduler);
                    break;

                case 6:
                    System.out.println("\n" + "=".repeat(70));
                    System.out.println("Thank you for using SJF Process Scheduler!");
                    System.out.println("Exiting program...");
                    System.out.println("=".repeat(70));
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1-6.");
            }

            if (choice != 6) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
            }

        } while (choice != 6);

        scanner.close();
    }

    private static void runSampleTestCase(SJFScheduler scheduler) {
        System.out.println("\n" + "═".repeat(80));
        System.out.println("SAMPLE TEST CASE EXECUTION");
        System.out.println("═".repeat(80));
        System.out.println("Adding 5 sample processes with different execution times...\n");

        // Sample processes
        String[][] sampleProcesses = {
                {"P1", "System Boot", "200"},
                {"P2", "User Login", "50"},
                {"P3", "File Transfer", "300"},
                {"P4", "Print Job", "100"},
                {"P5", "Backup", "150"}
        };

        for (int i = 0; i < sampleProcesses.length; i++) {
            int pid = Integer.parseInt(sampleProcesses[i][0].substring(1));
            scheduler.addProcess(pid, sampleProcesses[i][1], Integer.parseInt(sampleProcesses[i][2]));
        }

        System.out.println("\n" + "-".repeat(80));
        System.out.println("QUEUE STATUS BEFORE EXECUTION:");
        System.out.println("-".repeat(80));
        scheduler.showQueueStatus();

        System.out.println("\n" + "-".repeat(80));
        System.out.println("EXECUTING SJF SCHEDULING:");
        System.out.println("-".repeat(80));
        scheduler.executeSJF();

        System.out.println("\n" + "═".repeat(80));
        System.out.println("SAMPLE TEST COMPLETED!");
        System.out.println("═".repeat(80));
    }
}
