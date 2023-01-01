import java.util.*;
public class Optimal_Page_Replacement{
    static int search(int key, int frame[], int frame_size){
        int x = 0;
        for(int i = 0; i < frame_size; i++){
            if(key == frame[i]){
                x = 1;
            }
        }
        return x;
    }
    
    static int predict(int pages[], int frame[], int number_of_pages, int frame_size, int start){
        int position = Integer.MIN_VALUE;
        int res = -1;
        for(int i = 0; i < frame_size; i++){
            int j;
            for(j = start; j < number_of_pages; j++){
                if(pages[j] == frame[i]){
                    if(position < j){
                        position = j;
                        res = i;
                    }
                    break;
                }
            }
            if(j == number_of_pages){
                return i;
            }
        }
        return (res == -1) ? 0 : res;
    }
    
    static void optimalPage(int number_of_pages, int pages[], int frame_size){
        
        int frame[] = new int[frame_size];
        int f_sz = 0;

        int hit = 0;
        for(int i = 0; i < number_of_pages; i++){
            if(search(pages[i], frame, frame_size) == 1){
                hit++;
                continue;
            }

            
            if(f_sz < frame_size){
                frame[f_sz] = pages[i];
                f_sz++;
            }
            else{
                int position = predict(pages, frame, number_of_pages, frame_size, i + 1);
                frame[position] = pages[i];
            }
        }
