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

