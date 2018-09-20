package ru.snikhowski.lesson6;

import java.io.*;
import java.net.Socket;

public class Chat {
    private DataInputStream in;
    private DataOutputStream out;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Chat(Socket socket) {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Thread print = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    String s = in.readUTF();
                    System.out.println(s);
                    if (s.equals("/finish")) break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
    Thread write = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    String s = reader.readLine();
                    out.writeUTF(s);
                    if (s.equals("/finish")) break;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    });
}
