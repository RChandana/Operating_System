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
   pid = fork();
   if (pid == 0) {
      read(pipe_fds[0], read_message, sizeof(read_message));
      printf("Child Process - Reading from pipe – Message 1 is %s\n", read_message);
      read(pipe_fds[0], read_message, sizeof(read_message));
      printf("Child Process - Reading from pipe – Message 2 is %s\n", read_message);
   }
   
   else {
      printf("Parent Process - Writing to pipe - Message 1 is %s\n", write_messages[0]);
      write(pipe_fds[1], write_messages[0], sizeof(write_messages[0]));
      printf("Parent Process - Writing to pipe - Message 2 is %s\n", write_messages[1]);
      write(pipe_fds[1], write_messages[1], sizeof(write_messages[1]));
   }
   return 0;
}
