package ru.croc.task11;

import java.io.*;
import java.net.Socket;

/**
 * Клиентское приложение сначала предлагает ввести никнейм,
 * а далее отсылает на сервер каждую строку введённую пользователем
 */
public class Client {

    private String name;

    private static Socket socket;
    private static BufferedReader reader;

    private static BufferedReader in;
    private static BufferedWriter out;

    public Client(String addr, int port) {

        try {
            this.socket = new Socket(addr, port);

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите имя пользователя: ");
            name = bf.readLine();

        } catch (IOException e) {
            System.err.println("Socket failed");
        }

        new ClientRead(socket).start();
        new ClientWrite(socket, name).start();

        // in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


    }

    public void down() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {
        }
    }

}
