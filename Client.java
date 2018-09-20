package ru.snikhowski.lesson6;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1488);
            Chat chat = new Chat(socket);
            chat.print.start();
            chat.write.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
