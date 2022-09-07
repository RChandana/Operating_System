// Implementation of Multithreading using PTHREAD
#include <stdio.h> 
#include <stdlib.h> 
#include <unistd.h> 
#include <pthread.h> 
  
void *myThread(void *vargp) 
{ 
    sleep(1); 
    printf("Inside Thread \n"); 
    return NULL; 
} 

