#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>


const int maxx = 128;
void readem(char arg[], char *param[]){
  char *line = NULL;
  char *token;
  char *argv[maxx];
  int argc = 0;
  size_t buffsize = 0;


   getline(&line, &buffsize, stdin);
   // printf(line);
   //std::getline(std::cin , line);
  token = strtok(line, "\n");
  //printf(token);
  while( token != NULL)
    {
      argv[argc] = strdup(token);
      ++argc;
      token = strtok (NULL, "\n");
    }
  strcpy(arg,argv[0]);
  // printf(arg);

  for  (int i = 0; i < argc; ++i){
    param[i] = argv[i];
    printf("%s%s\n","Param ",param[i]);
  }
  param[argc] = NULL;
}
int main(int argc, char *argv[])
{
  char arg1[maxx], arg2[maxx], *param[24];
  while (true) {
   printf("Shello>>>> ");
    readem(arg2, param);
    //  char *arg3 = param[0];
    //  printf("%s%s\n""arg3 ",arg3);
    //    printf(arg2);
    pid_t pid = fork();
    if (pid == 0)
      {
      strcpy(arg1,"/bin/");
      strcat(arg1,arg2);
      /*      if(arg3 != NULL){
	execl(arg1,arg2,arg3,NULL);
      }
      else*/
       execvp(param[0],param);
       // execl(param,arg2,param[1],NULL);}
      }
  
      else  if(strcmp(param[0],"exit") == 0)
	exit(0);
    else{
      int child_status;
      waitpid(pid,&child_status,0);
    }	
    
  }
  return 0;
}
