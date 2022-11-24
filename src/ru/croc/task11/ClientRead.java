package ru.croc.task11;

import java.io.*;
import java.io.IOException;
import java.net.Socket;

public class ClientRead extends Thread {
    private static Socket socket;

    private static BufferedReader in;

    public ClientRead(Socket socket) {
        ClientRead.socket = socket;
    }

    @Override
    public void run() {

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {

                String serverWord = in.readLine();
                if (serverWord.equals("exit")) {
                    in.close();
                    socket.getInputStream().close();
                    ClientRead.socket.close();
                    break;
                }
                System.out.println(serverWord);
            }

        } catch (IOException e1) {
            // e1.printStackTrace();
            System.out.println("Сервер закрыт ");
        }

    }

}
