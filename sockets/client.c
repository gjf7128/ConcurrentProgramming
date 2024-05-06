#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <time.h>

void error(const char *msg)
{
    perror(msg);
    exit(0);
}

// For the connection overhead and speed
// int main(int argc, char *argv[])
// {
//     int sockfd, portno, n;
//     struct sockaddr_in serv_addr;
//     struct hostent *server;

//     // char buffer[256] = "0123456789";
//     if (argc < 3) {
//        fprintf(stderr,"usage %s hostname port\n", argv[0]);
//        exit(0);
//     }
//     portno = atoi(argv[2]);
//     // clock_t start = clock();

//     for (int i = 1; i <= 1000; i++) {
//         char buffer[256] = "0123456789";
//         sockfd = socket(AF_INET, SOCK_STREAM, 0);
//         if (sockfd < 0) 
//             error("ERROR opening socket");
//         server = gethostbyname(argv[1]);
//         if (server == NULL) {
//             fprintf(stderr,"ERROR, no such host\n");
//             exit(0);
//         }
//         int opt = 1;
//         if (setsockopt(sockfd, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt)) == -1) {
//             perror("setsockopt");
//             exit(EXIT_FAILURE);
//         }

//         bzero((char *) &serv_addr, sizeof(serv_addr));
//         serv_addr.sin_family = AF_INET;
//         bcopy((char *)server->h_addr, 
//              (char *)&serv_addr.sin_addr.s_addr,
//              server->h_length);
//         serv_addr.sin_port = htons(portno);
//         if (connect(sockfd,(struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0) 
//             error("ERROR connecting");
//         printf("Looping 1000x while sending 10 byte msg...");
//         // bzero(buffer,256);
//         // fgets(buffer,255,stdin);
//         n = write(sockfd,buffer,strlen(buffer));
//         if (n < 0) 
//             error("ERROR writing to socket");
//         // bzero(buffer,256);
//         memset(buffer, 0, sizeof(buffer));
//         n = read(sockfd,buffer,255);
//         if (n < 0) 
//             error("ERROR reading from socket");
//         printf("%s\n",buffer);
//         close(sockfd);
//         // bzero(buffer, strlen(buffer));
//         memset(buffer, 0, sizeof(buffer));
//     }

//     // This timer stuff is hardly accurate when using my phone timer in comparison, so i'm leaving it here,
//     // commented out
//     // double difference = ((double)(clock() - start)) / CLOCKS_PER_SEC;
//     // double differenceOverLoops = difference / 1000;
//     // printf("Connection time is %f seconds elapsed over %d iterations which equals %f seconds", difference, 1000, differenceOverLoops);
//     // printf("1000 loops have concluded");

//     return 0;
// }

// For getting bandwidth
int main(int argc, char *argv[])
{
    int sockfd, portno, n;
    struct sockaddr_in serv_addr;
    struct hostent *server;

    if (argc < 3) {
       fprintf(stderr,"usage %s hostname port\n", argv[0]);
       exit(0);
    }
    portno = atoi(argv[2]);

    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) 
        error("ERROR opening socket");
    server = gethostbyname(argv[1]);
    if (server == NULL) {
        fprintf(stderr,"ERROR, no such host\n");
        exit(0);
    }
    int opt = 1;
    if (setsockopt(sockfd, SOL_SOCKET, SO_REUSEADDR, &opt, sizeof(opt)) == -1) {
        perror("setsockopt");
        exit(EXIT_FAILURE);
    }
    bzero((char *) &serv_addr, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    bcopy((char *)server->h_addr, 
        (char *)&serv_addr.sin_addr.s_addr,
        server->h_length);
    serv_addr.sin_port = htons(portno);
    if (connect(sockfd,(struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0) 
        error("ERROR connecting");
    for (int i = 1; i <= 1000; i++) {
        char buffer[1401];
        memset(buffer, 'a', sizeof(buffer) - 1);
        buffer[sizeof(buffer) - 1] = '\0';
        printf("Looping 1000x while sending 1400 byte msg...");
        n = write(sockfd,buffer,sizeof(buffer));
        if (n < 0) 
            error("ERROR writing to socket");
        memset(buffer, 0, sizeof(buffer));
        n = read(sockfd,buffer,sizeof(buffer));
        if (n < 0) 
            error("ERROR reading from socket");
        printf("%s\n",buffer);
        memset(buffer, 0, sizeof(buffer));
    }
    close(sockfd);

    // This timer stuff is hardly accurate when using my phone timer in comparison, so i'm leaving it here,
    // commented out
    // double difference = ((double)(clock() - start)) / CLOCKS_PER_SEC;
    // double differenceOverLoops = difference / 1000;
    // printf("Connection time is %f seconds elapsed over %d iterations which equals %f seconds", difference, 1000, differenceOverLoops);
    // printf("1000 loops have concluded");

    return 0;
}
