package ru.croc.task11;

import java.io.*;
// import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Напишите клиент-серверное приложение
 */
public class Task11 {
    public static String ipAddr = "localhost";
    public static int port = 2000;
    public static void main(String[] args) throws UnknownHostException, IOException {

        new Client(ipAddr, port);
    }
}
