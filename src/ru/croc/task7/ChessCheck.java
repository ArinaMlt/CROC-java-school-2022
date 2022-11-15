package ru.croc.task7;

/**
 * Проверяющий класс
 */
public class ChessCheck {

    private ChessCheck() {
    }

    /**
     * метод, проверяющий,
     * что последовательность может быть пройдена фигурой конь в соответствии
     * с правилами хода этой фигуры (буквой "Г").
     * 
     * @param chess - массив объектов класса, определенных в текущей задаче.
     */
    public static void horse(Chess... chess) {
        boolean flag = true;
        int startX = chess[0].getX();
        int startY = chess[0].getY();
        if (chess.length == 2) {

            int endX = chess[1].getX();
            int endY = chess[1].getY();

            try {
                if (!ch(startX, startY, endX, endY))
                    throw new IllegalMoveException(chess[0], chess[1]);

            } catch (IllegalMoveException e) {
                // System.out.println(e.getMessage());
                flag = false;
            }

        } else {
            for (int i = 1; i < chess.length; i++) {
                // int startX = chess[0].getX();
                // int startY = chess[0].getY();

                int endX = chess[i].getX();
                int endY = chess[i].getY();

                try {
                    if (!ch(startX, startY, endX, endY))
                        throw new IllegalMoveException(chess[i - 1], chess[i]);
                    else {
                        startX = endX;
                        startY = endY;
                    }
                } catch (IllegalMoveException e) {
                    // System.out.println(e.getMessage());
                    flag = false;
                }

                // try {

                // if (((endX == startX + 2) && ((endY == startY + 1) || (endY == startY - 1)))
                // ||
                // ((endX == startX - 2) && ((endY == startY + 1) || (endY == startY - 1))) ||
                // ((endY == startY - 2) && ((endX == startX + 1) || (endX == startX - 1))) ||
                // ((endY == startY + 2) && ((endX == startX + 1) || (endX == startX - 1))))
                // return true;
                // else
                // throw new IllegalMoveException(chess[i], chess[i + 1]);
                // } catch (IllegalMoveException e) {
                // System.out.println(e.getMessage());
                // }

            }
        }
        if(flag) System.out.println("OK");

        // return true;
    }

    private static boolean ch(int startX, int startY, int endX, int endY) {

        if (((endX == startX + 2) && ((endY == startY + 1) || (endY == startY - 1))) ||
                ((endX == startX - 2) && ((endY == startY + 1) || (endY == startY - 1))) ||
                ((endY == startY - 2) && ((endX == startX + 1) || (endX == startX - 1))) ||
                ((endY == startY + 2) && ((endX == startX + 1) || (endX == startX - 1))))
            return true;
        else
            return false;

    }

}
