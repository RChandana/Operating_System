// Implementation of Multithreading using JAVA.
import java.lang.Thread;
import java.util.*;
class Multithread extends Thread{
   public void run(){
       try {
           System.out.println("Thread " + Thread.currentThread().getId() + " is running");
       }
       catch (Exception e) {
           System.out.println("Exception");
       }
   }
}
class Lab_2_Multithreading{
   public static void main(String args[]){
       int n;
       System.out.println("Enter the number of threads : ");
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       for (int i = 0; i < n; i++) {
           Multithread object = new Multithread();
           object.start();
       }
   }
}
