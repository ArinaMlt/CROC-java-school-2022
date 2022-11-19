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
    public static void knight(Chess... chess) {
        boolean flag = true;
        int startX = chess[0].getX();
        int startY = chess[0].getY();
        for (int i = 1; i < chess.length; i++) {

            int endX = chess[i].getX();
            int endY = chess[i].getY();

            try {
                if (!check(startX, startY, endX, endY))
                    throw new IllegalMoveException(chess[i - 1], chess[i]);
                else {
                    startX = endX;
                    startY = endY;
                }
            } catch (IllegalMoveException e) {
                flag = false;
            }
        }
        if (flag)
            System.out.println("OK");
    }

    private static boolean check(int startX, int startY, int endX, int endY) {

        final boolean isGoingRirght = ((endX == startX + 2) && ((endY == startY + 1) || (endY == startY - 1)));
        final boolean isGoingLeft = ((endX == startX - 2) && ((endY == startY + 1) || (endY == startY - 1)));
        final boolean isGoingUp = ((endY == startY + 2) && ((endX == startX + 1) || (endX == startX - 1)));
        final boolean isGoingDown = ((endY == startY - 2) && ((endX == startX + 1) || (endX == startX - 1)));

        if (isGoingDown || isGoingUp || isGoingLeft || isGoingRirght)
            return true;
        else
            return false;

    }

}
