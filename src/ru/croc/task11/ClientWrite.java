package ru.croc.task11;

import java.io.*;
import java.net.Socket;

public class ClientWrite extends Thread {
    private static Socket socket;
    private static BufferedReader reader;
    private String name;

    private static BufferedWriter out;

    public ClientWrite(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        String word;
        try {
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                word = reader.readLine();
                if (word.equals("exit")) {
                    out.write(word);
                    out.flush();
                    out.close();
                    ClientWrite.socket.close();
                } else {
                    out.write(name + ": " + word + "\n");
                    out.flush();
                }
            }

        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("Сервер закрыт ");
        }

    }

}
