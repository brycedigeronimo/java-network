Author: Bryce Di Geronimo

CIS 212 Assignment 8

Description

The goal of this assignment is to gain experience with network programming, specifically with sockets in Java. This assignment will also require you to develop a server and a client simultaneously.The client will allow the user to enter an arbitrary list of integers to be sent to the server. The server will then return a list of prime integers contained in the original list.


Instructions

1. Create two classes, one for your client and one for your server.  Each class will need a main method so that both classes can be executed.

2. Implement your client to prompt the user to enter a list of integers(and use “!” to end the list.) Send the list of integers to the server (hint: see java.net.Socket), print the list of integers sent to the server, and later print the list of prime integers received from the server.

3. Implement your server to wait for a socket connection(hint: see java.net.ServerSocket).  When a socket is accepted, read a list of integers, determine which in the list are prime, and then send a list containing the prime integers back to the client.Your server may or may not shut down after completing this process.

Your client output should look something like:

Enter an integer(“!”to send):

3

Enter an integer (“!” to send):

4

Enter an integer (“!” to send):

5

Enter an integer (“!” to send):

7

Enter an integer (“!” to send):

!

Send: [3,4,5,7]
Receive: [3,5,7]

To run application, run the server before the client