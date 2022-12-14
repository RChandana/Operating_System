import java.util.*;
class OS_Assignment_1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes : ");
        int n = sc.nextInt();
        int process_id[] = new int[n];
        int arrival[] = new int[n];
        int burst_time[] = new int[n]; 
        int turn_around[] = new int[n];
        int completion_time[] = new int[n]; 
        int wait[] = new int[n];
        float avg_wait = 0;
        int temp;

        for(int i = 0; i < n; i++){
            System.out.println("enter process " + (i+1) + " arrival time: ");
            arrival[i] = sc.nextInt();

            System.out.println("enter process " + (i+1) + " brust time: ");
            burst_time[i] = sc.nextInt();

            process_id[i] = i + 1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-(i+1); j++){
                if(arrival[j] > arrival[j + 1]){
                    temp = arrival[j];
                    arrival[j] = arrival[j + 1];
                    arrival[j + 1] = temp;

                    temp = burst_time[j];
                    burst_time[j] = burst_time[j+1];
                    burst_time[j+1] = temp;

                    temp = process_id[j];
                    process_id[j] = process_id[j + 1];
                    process_id[j + 1] = temp;
                }
            }
        }
        for(int  i = 0 ; i < n; i++){
            if( i == 0){
                completion_time[i] = arrival[i] + burst_time[i];
            }
            else{
                if( arrival[i] > completion_time[i-1]){
                    completion_time[i] = arrival[i] + burst_time[i];
                }
                else
                completion_time[i] = completion_time[i-1] + burst_time[i];
            }
            turn_around[i] = completion_time[i] - arrival[i] ;
            wait[i] = turn_around[i] - burst_time[i] ; 
            avg_wait += wait[i] ; 
        }
        System.out.println("\nProcessID  Arrival  Burst_Time  Waiting");
        for(int i = 0; i < n; i++){
            System.out.println("\t " + process_id[i] + "\t " + arrival[i] + "\t " + burst_time[i] + "\t " + wait[i]);
        }
        sc.close();
        System.out.println("\nAverage waiting time: "+ (avg_wait/n));
    }
}
