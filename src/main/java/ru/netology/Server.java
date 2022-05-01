package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main( String[] args ){
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.println("Write your name!");
            String name = in.readLine();
            System.out.println(name);
            out.println("Are you child? (yes/no)");
            String answer = in.readLine();
            System.out.println(answer);
            if (answer.equals("yes")) {
                out.println("Welcome to the kids area, " + name + "! Let's play!");
            } else if (answer.equals("no")) {
                out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
            } else {
                out.println("Error, you should have chosen yes or no");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
