package ru.croc.task11;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Сервер ждет подключения пользователей, принимает текстовые сообщения,
 * которые пересылает всем подключенным клиентам.
 */
public class Server{

    public static final int PORT = 2000;
    public static LinkedList<ServerReadWrite> serverList = new LinkedList<>(); 

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server Started");
        try {
            while (true) {

                Socket socket = server.accept();
                try {
                    serverList.add(new ServerReadWrite(socket)); 
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }

}
