import java.util.*; 
    class Least_Recently_Used {
        int p[], n, fr[], m, fs[], index, k, l, flag_1 = 0, flag_2 = 0, page_faults = 0, frame_size = 3, i, j; 
        Scanner sc = new Scanner(System.in); 
        void read() { 
            System.out.println("Enter page table size : "); 
            n = sc.nextInt(); 
			p = new int[n]; 
            System.out.println("Enter the Reference String : "); 
            for(int i = 0; i < n; i++) 
            p[i] = sc.nextInt(); 
            System.out.println("Enter the Number of frames : "); 
            m = sc.nextInt(); 
            fr = new int[m]; 
            fs = new int[m]; 
        }
