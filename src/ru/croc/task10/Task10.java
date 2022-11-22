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

        // System.out.println(LocalDateTime.now());

        Bet bet1 = new Bet("cat", 5);
        Bet be2 = new Bet("dog", 4);
        bet1.start();
        be2.start();

    }

}
