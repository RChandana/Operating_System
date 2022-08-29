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
