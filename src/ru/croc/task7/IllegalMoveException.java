package ru.croc.task7;

public class IllegalMoveException extends Exception {

    public IllegalMoveException(Chess chess1, Chess chess2) {
        System.err.println("Конь так не ходит: " + chess1 + " -> " + chess2);
    }

}