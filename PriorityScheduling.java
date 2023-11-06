import java.util.Scanner;

public class PriorityScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i =0, n=0;
        // Input the number of processes
        System.out.print("Enter the number of processes: ");
        n = sc.nextInt();
     
        int[] process = new int[n];
        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] priority = new int[n];
        int[] completionTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];
        for (i = 0; i < n; i++) {
        process[i] = i + 1;
        }
            System.out.println("Enter arrival time for process " + (i + 1) + ": ");
            for (i = 0; i < n; i++) {
            arrivalTime[i] = sc.nextInt();
            }
            System.out.println("Enter burst time for process " + (i + 1) + ": ");
            for (i = 0; i < n; i++) {
            burstTime[i] = sc.nextInt();
            }
            System.out.println("Enter priority for process " + (i + 1) + ": ");
            for (i = 0; i < n; i++) {
            priority[i] = sc.nextInt();
        }
        
        // Sort the processes based on arrival time and priority
        for ( i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ( arrivalTime[i] > arrivalTime[j] || (arrivalTime[i] == arrivalTime[j] && priority[i] > priority[j])) {
                    // Swap process details
                    int temp = process[i];
                    process[i] = process[j];
                    process[j] = temp;
                    
                    temp = arrivalTime[i];
                    arrivalTime[i] = arrivalTime[j];
                    arrivalTime[j] = temp;
                    
                    temp = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = temp;
                    
                    temp = priority[i];
                    priority[i] = priority[j];
                    priority[j] = temp;
                }
            }
        }
        
        // Calculate completion time, turnaround time, and waiting time
        int currentTime = 0;
        for (i = 0; i < n; i++) {
            currentTime += burstTime[i];
            completionTime[i] = currentTime;
            turnaroundTime[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnaroundTime[i] - burstTime[i];
        }
        
        // Calculate average waiting time and average turnaround time
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;
        for ( i = 0; i < n; i++) {
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
        }
        avgWaitingTime /= n;
        avgTurnaroundTime /= n;
        
        // Display the results
        System.out.println("Process\tArrival Time\tBurst Time\tPriority\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (i = 0; i < n; i++) {
            System.out.println(process[i] + "\t" + arrivalTime[i] + "\t\t" + burstTime[i] + "\t\t" + priority[i] + "\t\t"
                    + completionTime[i] + "\t\t" + turnaroundTime[i] + "\t\t" + waitingTime[i]);
        }
        
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}
