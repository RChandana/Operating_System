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
