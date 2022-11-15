package ru.croc.task7;

public class Task7 {
    public static void main(String[] args) {

        // char a = 'a';
        // int k = a+2;

        // System.out.println((char) (a+2));

        // Chess one = new Chess(1, 1);
        // System.out.println(one);

        // String a = "b2";
        // char[] b = a.toCharArray();
        // int x = b[0];
        // System.out.println(x);

        // System.out.println(Chess.parse("b2"));

        // System.out.println(Chess.parse("a1"));

        // Chess c = new Chess(8, 3);

        String[] s = { "b1", "a3", "c4", "d6" };

        // System.out.println(Chess.parse("g8"));

        // ChessCheck.horse(Chess.parse("g8"), Chess.parse("e7"),Chess.parse("e6"));
        ChessCheck.horse(Chess.parse("g8"), Chess.parse("e7"),Chess.parse("c8"));

    }
}
