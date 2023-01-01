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
