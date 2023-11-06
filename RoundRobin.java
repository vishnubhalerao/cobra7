import java.util.*;

public class RoundRobin {
    public static void roundRobin(int[] arrivalTime, int[] burstTime, int quantum, int n) {

        int[] remainingTime = new int[n];
        int[] completionTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        // Initialize the remaining time with burst time
        for (int i = 0; i < n; i++) {
            remainingTime[i] = burstTime[i];
        }

        Queue<Integer> queue = new LinkedList<>();
        int currentTime = 0;
        int idx = 0;

        while (true) {
            boolean done = true;

            for (int i = 0; i < n; i++) {
                if (arrivalTime[i] <= currentTime) {
                    if (remainingTime[i] > 0) {
                        done = false;
                        if (remainingTime[i] <= quantum) {
                            currentTime += remainingTime[i];
                            completionTime[i] = currentTime;
                            remainingTime[i] = 0;
                        } else {
                            currentTime += quantum;
                            remainingTime[i] -= quantum;
                        }
                        while (idx < n && arrivalTime[idx] <= currentTime) {
                            queue.add(idx);
                            idx++;
                        }
                    }
                }
            }

            if (done)
                break;

            if (!queue.isEmpty()) {
                int processIdx = queue.poll();
                queue.add(processIdx);
            } else {
                currentTime++;
            }
        }

        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnaroundTime[i] - burstTime[i];
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        double avgWaitingTime = (double) totalWaitingTime / n;
        double avgTurnaroundTime = (double) totalTurnaroundTime / n;

        // Print the results
        System.out
                .println("Process\tAT \tBT \tCT \tTAT \tWT");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t" + arrivalTime[i] + "\t" + burstTime[i] + "\t" + completionTime[i] + "\t"
                    + turnaroundTime[i] + "\t" + waitingTime[i]);
        }

        System.out.println("\nAverage Turnaround Time: " + avgTurnaroundTime);
        System.out.println("Average Waiting Time: " + avgWaitingTime);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes :");
        int n = sc.nextInt();
        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        System.out.println("Enter Arrival Time for process: ");
        for (int i = 0; i < n; i++) {
            System.out.print("\t p" + (i + 1) + ": ");
            arrivalTime[i] = sc.nextInt();
        }
        System.out.println("Enter Burst Time for process: ");
        for (int i = 0; i < n; i++) {
            System.out.print("\t p" + (i + 1) + ": ");
            burstTime[i] = sc.nextInt();
        }
        System.out.print("Enter quantum:");
        int quantum = sc.nextInt();

        roundRobin(arrivalTime, burstTime, quantum, n);
    }
}
