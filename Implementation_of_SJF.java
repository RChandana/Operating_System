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
        
        for(int i = 0; i < n; i++){
            System.out.println("Enter process " + (i + 1) + " arrival time: ");
            arrival[i] = sc.nextInt();

            System.out.println("Enter process " + (i + 1) + " brust time: ");
            burst_time[i] = sc.nextInt();

            process_id[i] = i + 1;
            flag[i] = 0;
        }
        
        boolean a = true;
        while(true){
            int c = n, min = 999;
            if (total == n) 
            break;
            for (int i = 0; i < n; i++){
                if ((arrival[i] <= system_time) && (flag[i] == 0) && (burst_time[i] < min)){
                    min = burst_time[i];
                    c = i;
                }
            }
            
            if (c == n)
            system_time++;
            else{
                completion_time[c] = system_time + burst_time[c];
                system_time += burst_time[c];
                turn_around[c] = completion_time[c] - arrival[c];
                wait[c] = turn_around[c] - burst_time[c];
                flag[c] = 1;
                total++;
            }
        }
