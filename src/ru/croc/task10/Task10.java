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

        Bet bet = new Bet(one, "catTom");

        Thread bet1 = new Thread(bet);

        bet1.start();

    }

}
