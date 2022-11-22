package ru.croc.task10;

import java.time.LocalDateTime;

import javax.imageio.IIOException;

public class Bet extends Thread {
    private int price;
    private String name;

    private static Lot one = new Lot(1, LocalDateTime.of(2022, 12, 19, 11, 11));

    public Bet(String name, int price) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (one) {
            if (one.getTime().isAfter(LocalDateTime.now()))
                try {
                    one.rates(price, name);
                } catch (IIOException e) {
                    e.printStackTrace();
                }
            else
                this.interrupt();
        }
        System.out.println(one.getName());

    }

}
