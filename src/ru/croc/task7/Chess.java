package ru.croc.task7;

/**
 * Класс описывает позицию на шахматной доске 8*8
 */
public class Chess {
    int x;
    int y;
    // {
    // //нижняя левая клетка
    // x = 0;
    // y = 0;
    // }

    public Chess(int x, int y) {
        // System.out.println(x + " //" + y);
        try {
            if (x > 8 || x < 0 || y > 8 || y < 0)
                throw new IllegalPositionException("wrong position");
            else {
                this.x = x;
                this.y = y;
            }
        } catch (IllegalPositionException e) {
            System.err.println(e.getMessage());
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        int x = getX();
        int y = getY();
        char a = 'a';
        return "" + (char) (a + x) + (y + 1);
    }

    public static Chess parse(String position) {
        char[] c = position.toCharArray();
        return new Chess((c[0] - 'a'), (Character.digit(c[1],10) - 1));
    }

}
