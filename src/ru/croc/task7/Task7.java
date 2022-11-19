package ru.croc.task7;

public class Task7 {
    public static void main(String[] args) throws IllegalPositionException {

        // Конь так не ходит: e7 -> e6
        // ChessCheck.knight(Chess.parse("g8"), Chess.parse("e7"), Chess.parse("e6"));

        // Illegal position!
        // ChessCheck.knight(Chess.parse("k8"), Chess.parse("e7"),Chess.parse("e6"));

        // OK
        // ChessCheck.knight(Chess.parse("g8"), Chess.parse("e7"),Chess.parse("c8"));

        // OK
        ChessCheck.knight(Chess.parse("g8"), Chess.parse("e7"));

    }
}
