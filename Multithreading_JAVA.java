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

