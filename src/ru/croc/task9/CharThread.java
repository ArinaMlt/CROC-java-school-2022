package ru.croc.task9;

public class CharThread extends Thread {
    private final char c;

    public CharThread(char c) {
        this.c = c;
    }

    public void run() {
        while (true) {
            System.out.print(c);
        }
    }

}
