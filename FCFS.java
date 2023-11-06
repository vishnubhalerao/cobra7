import java.util.*;

public class FCFS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int processNo = 0, i, BT[], AT[], CT[], TAT[], WT[];
        float avgTAT = 0, avgWT = 0;
        BT = new int[10];
        AT = new int[10];
        CT = new int[50];
        TAT = new int[50];
        WT = new int[50];
        System.out.print("Enter the number of process: ");
        processNo = sc.nextInt();
        System.out.println("Enter Burst Time for process: ");
        for (i = 0; i < processNo; i++) {
            System.out.print("\tp" + (i + 1) + ": ");
            BT[i] = sc.nextInt();
        }
        System.out.println("Enter Arrival Time for process: ");
        for (i = 0; i < processNo; i++) {
            System.out.print("\t p" + (i + 1) + ": ");
            AT[i] = sc.nextInt();
        }
        CT[0] = AT[0] + BT[0];
        TAT[0] = CT[0] - AT[0];
        WT[0] = TAT[0] - BT[0];
        for (i = 1; i < processNo; i++) {
            CT[i] = Math.max(CT[i - 1], AT[i]) + BT[i];
            TAT[i] = CT[i] - AT[i];
            WT[i] = TAT[i] - BT[i];
        }
        for (i = 0; i < processNo; i++) {

            avgTAT += TAT[i];
            avgWT += WT[i];
        }
        avgTAT /= processNo;
        avgWT /= processNo;

        System.out.println("\n***********************************************************");
        System.out.println("\t Processes: ");
        System.out.println("\n***********************************************************");
        System.out.println(" \tP \tBT \tAT \tCT \tTAT \tWT");
        for (i = 0; i < processNo; i++) {
            System.out.println("\tp" + (i + 1) + "\t" + BT[i] + "\t" + AT[i] + "\t" + CT[i] + "\t" + TAT[i]
                    + "\t" + WT[i] + "\n");

        }
        System.out.println("\n***********************************************************");
        System.out.println("Avg Turn around time = " + avgTAT + "\n");
        System.out.println("Avg Waiting time = " + avgWT);
    }

}
