/* A simple server in the internet domain using TCP
   The port number is passed as an argument */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <netinet/in.h>

void error(const char *msg)
{
    perror(msg);
    exit(1);
}

// This code gets connection overhead and speed
// int main(int argc, char *argv[])
// {
//      int sockfd, newsockfd, portno;
//      socklen_t clilen;
//      char buffer[256];
//      struct sockaddr_in serv_addr, cli_addr;
//      int n;
//      if (argc < 2) {
//          fprintf(stderr,"ERROR, no port provided\n");
//          exit(1);
//      }
//      int count = 1;
//      while (count <= 1000) {
//          sockfd = socket(AF_INET, SOCK_STREAM, 0);
//          int opt = 1;
//          if (setsockopt(sockfd, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt)) == -1) {
//              perror("setsockopt");
//              exit(EXIT_FAILURE);
//          }        
//          if (sockfd < 0) 
//              error("ERROR opening socket");
//          bzero((char *) &serv_addr, sizeof(serv_addr));
//          portno = atoi(argv[1]);
//          serv_addr.sin_family = AF_INET;
//          serv_addr.sin_addr.s_addr = INADDR_ANY;
//          serv_addr.sin_port = htons(portno);
//          if (bind(sockfd, (struct sockaddr *) &serv_addr,
//                   sizeof(serv_addr)) < 0) 
//                   error("ERROR on binding");
//          listen(sockfd,5);
//          clilen = sizeof(cli_addr);
//          newsockfd = accept(sockfd, 
//                  (struct sockaddr *) &cli_addr, 
//                  &clilen);
//          if (newsockfd < 0) 
//               error("ERROR on accept");
//         //  bzero(buffer,256);
//          memset(buffer, 0, sizeof(buffer));
//          n = read(newsockfd,buffer,255);
//          if (n < 0) error("ERROR reading from socket");
//          printf("Here is the message: %s\n",buffer);
//          n = write(newsockfd,"I got your message",20);
//          if (n < 0) error("ERROR writing to socket");
//          close(newsockfd);
//          close(sockfd);
//          count = count + 1;
//      }
//     //  listen(sockfd,5);
//     //  clilen = sizeof(cli_addr);
//     //  newsockfd = accept(sockfd, 
//     //              (struct sockaddr *) &cli_addr, 
//     //              &clilen);
//     //  if (newsockfd < 0) 
//     //       error("ERROR on accept");
//     //  bzero(buffer,256);
//     //  n = read(newsockfd,buffer,255);
//     //  if (n < 0) error("ERROR reading from socket");
//     //  printf("Here is the message: %s\n",buffer);
//     //  n = write(newsockfd,"I got your message",18);
//     //  if (n < 0) error("ERROR writing to socket");
//      return 0; 
// }


// For finding bandwidth
int main(int argc, char *argv[])
{
     int sockfd, newsockfd, portno;
     socklen_t clilen;
     char buffer[1401];
     struct sockaddr_in serv_addr, cli_addr;
     int n;
     if (argc < 2) {
         fprintf(stderr,"ERROR, no port provided\n");
         exit(1);
     }

     sockfd = socket(AF_INET, SOCK_STREAM, 0);
     int opt = 1;
     if (setsockopt(sockfd, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt)) == -1) {
         perror("setsockopt");
         exit(EXIT_FAILURE);
     }        
     if (sockfd < 0) 
         error("ERROR opening socket");
     bzero((char *) &serv_addr, sizeof(serv_addr));
     portno = atoi(argv[1]);
     serv_addr.sin_family = AF_INET;
     serv_addr.sin_addr.s_addr = INADDR_ANY;
     serv_addr.sin_port = htons(portno);
     if (bind(sockfd, (struct sockaddr *) &serv_addr,
         sizeof(serv_addr)) < 0) 
         error("ERROR on binding");
     listen(sockfd,5);
     clilen = sizeof(cli_addr);
     newsockfd = accept(sockfd, 
         (struct sockaddr *) &cli_addr, 
         &clilen);
     if (newsockfd < 0) 
         error("ERROR on accept");
     int count = 1;
     while (count <= 1000) {
         memset(buffer, 0, sizeof(buffer));
         n = read(newsockfd,buffer, sizeof(buffer));
         if (n < 0) error("ERROR reading from socket");
         memset(buffer, 'a', sizeof(buffer) - 1);
         buffer[sizeof(buffer) - 1] = '\0';
        printf("msg received");
         n = write(newsockfd, buffer, sizeof(buffer));
         if (n < 0) error("ERROR writing to socket");
         count = count + 1;
     }
     close(newsockfd);
     close(sockfd);
     return 0; 
}
