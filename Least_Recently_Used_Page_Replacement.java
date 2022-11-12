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
      void display() { 
        System.out.println("\n"); 
        for(i = 0; i < m; i++) { 
			if(fr[i] == -1) 
            System.out.println("[ ]"); 
        else 
		    System.out.println("[" + fr[i] + "]"); 
        } 
    } 

    void lru() { 
        for(i = 0; i < m; i++) { 
			fr[i] =- 1; 
        } 
		for(j = 0; j < n; j++){ 
			flag_1 = 0;
			flag_2 = 0; 
		for(i = 0; i < m; i++){ 
			if(fr[i] == p[j]) { 
				flag_1 = 1; 
				flag_2 = 1; 
				
				break; 
			} 
		} 
		
		if(flag_1 == 0){ 
			for(i = 0; i < m; i++){ 
				if(fr[i] == -1){
					fr[i] = p[j]; 
					flag_2 = 1; 
					
					break;
				} 
			} 
		} 
			
		if(flag_2 == 0){ 
			for(i = 0; i < 3; i++)
			fs[i] = 0; 
			for(k = j - 1, l = 1; l <= frame_size - 1; l++, k--){ 
				for(i = 0; i < 3; i++){ 
					if(fr[i] == p[k]) 
					fs[i] = 1;
				}
			} 
			for(i = 0; i < 3; i++){ 
				if(fs[i] == 0) 
				index = i;
			} 
			fr[index] = p[j]; 
			page_faults++; 
		} 
			
		System.out.print("Page : " + p[j]);
		display(); 
	} 
    System.out.println("\n Number of page faults : " + page_faults); 
} 
public static void main(String args[]){ 
	Least_Recently_Used a = new Least_Recently_Used(); 
	a.read(); 
	a.lru(); 
	a.display(); 
	} 
}
