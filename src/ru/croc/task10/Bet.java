package ru.croc.task10;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Bet implements Runnable {

    private Scanner scanner = new Scanner(System.in);
    private Lot lot;
    private String name;
    private int price = -1;
    private int nowPrice; // текущая ставка

    private Bet() {

    }

    public Bet(Lot lot, String name) {
        this.lot = lot;
        this.name = name;
    }

    private LocalDateTime time;

    @Override
    public void run() {
        time = lot.getTime();
        // System.out.println("Аукцион открыт.");

        while (time.isAfter(LocalDateTime.now())) {
            nowPrice = lot.getPrice();
            if (nowPrice > price) {
                // System.out.println("текущая ставка: " + nowPrice);

                // System.out.println(name + ", введите Вашу ставку: ");
                // price = scanner.nextInt();
                price = nowPrice + 1;
                lot.rates(price, name);

                // while (!lot.rates(price, name)) {
                // System.out.println("ставка не принята, введите Вашу ставку: ");
                // // price = scanner.nextInt();
                // price = nowPrice + 2;
                // }
            }
        }
    }

}
