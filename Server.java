package ru.snikhowski.lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1488);
            System.out.println("Server is on. Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");
            Chat chat = new Chat(socket);
            chat.print.start();
            chat.write.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
