package ru.croc.task11;

import java.io.*;
import java.net.Socket;

public class ServerReadWrite extends Thread {
    private Socket socket;

    private BufferedReader in; 
    private BufferedWriter out; 

    public ServerReadWrite(Socket socket) throws IOException {
        this.socket = socket;

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        start(); 
    }

    @Override
    public void run() {

        String word;
        try {

            while (true) {
                word = in.readLine(); 

                if (word.equals("exit")) {
                    this.down();
                    break;
                }

                out.write("Привет, это Сервер! Подтверждаю, вы написали : " + word + "\n");
                out.flush();
                System.out.println("Echo: " + word);

                for (ServerReadWrite rw : Server.serverList) {
                    rw.send(word); 
                }

            }
        } catch (IOException e) {
            this.down();
        }
    }

    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {
        }
    }

    private void down() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                for (ServerReadWrite rw : Server.serverList) {
                    if (rw.equals(this))
                        rw.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {
        }
    }
}
