#include<stdio.h>
#include<unistd.h>

int main() {
   int pipe_fds[2];
   int return_status;
   int pid;
   char write_messages[2][20]={"Hi", "Hello"};
   char read_message[20];
   return_status = pipe(pipe_fds);
   if (return_status == -1) {
      printf("Unable to create pipe\n");
      return 1;
   }
