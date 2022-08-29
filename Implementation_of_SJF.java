import java.util.*;
public class Lab_1_SJF {  
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter the number of process:");
        int n = sc.nextInt();
        int process_id[] = new int[n];
        int arrival[] = new int[n];
        int burst_time[] = new int[n]; 
        int turn_around[] = new int[n];
        int completion_time[] = new int[n]; 
        int wait[] = new int[n];  
        int flag[] = new int[n];  
        int system_time = 0, total = 0;
        float avg_wait = 0;
