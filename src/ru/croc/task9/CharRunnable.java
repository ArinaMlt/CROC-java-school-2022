package ru.croc.task9;

public class CharRunnable implements Runnable {

    private final char c;
    private final float frequency;
    private static int numPrinted = 0;

    public CharRunnable(char c, float frequency) {
        this.c = c;
        this.frequency = frequency;
    }

    public void run() {
        while (true) {
            System.out.print(c);
            numPrinted++;
            if (numPrinted % 16 == 0)
                System.out.println();

            try {
                Thread.sleep((long) (1e3 / frequency));
            } catch (InterruptedException e) {
                break; // stop execution if thread was interrupted
            }

        }
    }

}
