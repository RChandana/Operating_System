mport java.util.*;
public class Lab_1_RR {
    public static void main(String args[]){
        int n, i, time_slice, count = 0, temp, sq = 0, burst_time[], wait[], turn_around[], rem_bt[];
        float avg_wait = 0;
        burst_time = new int[10];
        wait = new int[10];
        turn_around = new int[10];
        rem_bt = new int[10];
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes : ");
        n = sc.nextInt();
        System.out.print("Enter burst time of process\n");
        for (i = 0; i < n; i++){
            System.out.print("P" + i + " = ");
            burst_time[i] = sc.nextInt();
            rem_bt[i] = burst_time[i];
        }
        
        System.out.print("Enter Time Slice = ");
        time_slice = sc.nextInt();
        while(true){
            for (i = 0, count = 0; i < n; i++){
                temp = time_slice;
                if(rem_bt[i] == 0){
                    count++;
                    continue;
                }
                if(rem_bt[i] > time_slice)
                rem_bt[i] = rem_bt[i] - time_slice;
                else
                if(rem_bt[i] >= 0){
                    temp = rem_bt[i];
                    rem_bt[i] = 0;
                }
                sq = sq + temp;
                turn_around[i] = sq;
            }
            if(n == count)
            break;
        }
