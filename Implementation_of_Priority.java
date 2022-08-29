import java.util.*;
public class Lab_1_Priority {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes : ");
        int n = sc.nextInt();
        int process_id[] = new int[n];
        int arrival[] = new int[n];
        int burst_time[] = new int[n]; 
        int turn_around[] = new int[n];
        int wait[] = new int[n];
        int process_priority[] = new int[n];
        float avg_wait = 0;
        int x;
        
        for(int i = 0; i < n; i++){
            System.out.println("Enter process " + (i + 1) + " arrival time: ");
            arrival[i] = sc.nextInt();

            System.out.println("Enter process " + (i + 1) + " brust time: ");
            burst_time[i] = sc.nextInt();

            System.out.println("Enter process " + (i + 1) + " priority : ");
            process_priority[i] = sc.nextInt();

            process_id[i] = i + 1;
        }
        
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(process_priority[i] > process_priority[j]){
                    x = process_priority[i];
                    process_priority[i] = process_priority[j];
                    process_priority[j] = x;
                    x = burst_time[i];
                    burst_time[i] = burst_time[j];
                    burst_time[j] = x;
                    x = process_id[i];
                    process_id[i] = process_id[j];
                    process_id[j] = x;
                }
            }
        }
