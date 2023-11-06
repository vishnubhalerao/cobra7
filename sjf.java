import java.util.*;

public class sjf {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of process:");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n]; 
        int bt[] = new int[n]; 
        int ct[] = new int[n]; 
        int ta[] = new int[n]; 
        int wt[] = new int[n];
        int f[] = new int[n]; 
        int st = 0, tot = 0;
        float avgwt = 0, avgta = 0;
        

            System.out.println("enter process arrival time:");
            for(int j =0; j<n; j++){
                at[j] = sc.nextInt();
            }
            System.out.println("enter process brust time:");
            for(int j =0; j<n; j++){
                bt[j] = sc.nextInt();
            }
            for(int i=0; i< n; i++){
                pid[i] = i + 1;
                f[i] = 0;
            }
            
        boolean a = true;
        while (true) {
            int c = n, min = 999;
            if (tot == n) 
                break;
            for (int i = 0; i < n; i++) {
                
                if ((at[i] <= st) && (f[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
            }
          
            if (c == n)
                st++;
            else {
                ct[c] = st + bt[c];
                st += bt[c];
                ta[c] = ct[c] - at[c];
                wt[c] = ta[c] - bt[c];
                f[c] = 1;
                tot++;
            }
        }
        System.out.println("\npid \tAT \tBT \tCT \tTAT \tWT");
        for (int i = 0; i < n; i++) {
            avgwt += wt[i];
            avgta += ta[i];
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
        }
        System.out.println("\naverage tat is " + (float) (avgta / n));
        System.out.println("average wt is " + (float) (avgwt / n));
        sc.close();
    }
}