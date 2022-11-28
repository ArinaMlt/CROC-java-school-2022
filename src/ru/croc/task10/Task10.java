package ru.croc.task10;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Делать ставки на лот одновременно могут сразу несколько пользователей.
 * 
 * Реализуйте класс LOT по описанию так,
 * чтобы одновременное участие в ставках большого количества пользователей
 * не приводило к ошибкам в проведении аукциона (то есть, потокобезопасно).
 * 
 */
public class Task10 {
    public static void main(String[] args) {

        // создать лот
        // Lot one = new Lot(1, LocalDateTime.of(2022, 12, 19, 11, 11));
        LocalDateTime closeLot = LocalDateTime.now().plus(1, ChronoUnit.MINUTES);
        System.out.println(closeLot);
        Lot one = new Lot(1, closeLot);

        Bet betOne = new Bet(one, "catTom");
        Bet betTwo = new Bet(one, "dogJack");
        Bet betThree = new Bet(one, "frogNik");

        Thread bet1 = new Thread(betOne);
        Thread bet2 = new Thread(betTwo);
        Thread bet3 = new Thread(betThree);

        bet1.start();
        bet2.start();
        bet3.start();

        System.out.println("Аукцион открыт.");

        while ((one.getTime()).isAfter(LocalDateTime.now())) {
        }
        System.out.println("Аукцион закрыт");
        System.out.println("Выиграла ставка - " + one.getName() + " " + one.getPrice());
    }

}
