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
    // private static Socket clientSocket; // сокет для общения
    // private static ServerSocket server; // серверсокет
    // private static BufferedReader in; // поток чтения из сокета
    // private static BufferedWriter out; // поток записи в сокет

    // public static void main(String[] args) {
    //     String word;
    //     try {
    //         try {
    //             server = new ServerSocket(2000); // серверсокет прослушивает порт 4004
    //             System.out.println("started"); // хорошо бы серверу
    //             // объявить о своем запуске
    //             clientSocket = server.accept(); // accept() будет ждать пока
    //             // кто-нибудь не захочет подключиться
    //             try { // установив связь и воссоздав сокет для общения с клиентом можно перейти
    //                   // к созданию потоков ввода/вывода.
    //                   // теперь мы можем принимать сообщения
    //                 in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    //                 // и отправлять
    //                 out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

    //                 while (true) {
    //                     word = in.readLine(); // ждём пока клиент что-нибудь нам напишет
    //                     if (word.equals("exit")) {
    //                         // this.downService(); // харакири
    //                         break; // если пришла пустая строка - выходим из цикла прослушки
    //                     }

    //                     out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
    //                     out.flush();
    //                     System.out.println("Echo: " + word);

    //                 }

    //                 // System.out.println("Echo: " + word);
    //                 // System.out.println(word);
    //                 // // не долго думая отвечает клиенту
    //                 // out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
    //                 // out.flush(); // выталкиваем все из буфера

    //             } finally { // в любом случае сокет будет закрыт
    //                 clientSocket.close();
    //                 // потоки тоже хорошо бы закрыть
    //                 in.close();
    //                 out.close();
    //             }
    //         } finally {
    //             System.out.println("Сервер закрыт!");
    //             server.close();
    //         }
    //     } catch (IOException e) {
    //         System.err.println(e);
    //     }
    // }

    // /**
    //  * закрытие сервера
    //  * прерывание себя как нити и удаление из списка нитей
    //  */
    // // private void downService() {
    // // try {
    // // if(!socket.isClosed()) {
    // // socket.close();
    // // in.close();
    // // out.close();
    // // for (ServerSomthing vr : Server.serverList) {
    // // if(vr.equals(this)) vr.interrupt();
    // // Server.serverList.remove(this);
    // // }
    // // }
    // // } catch (IOException ignored) {}
    // // }
    // // }


}
