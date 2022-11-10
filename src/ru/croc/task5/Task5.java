package ru.croc.task5;

import ru.croc.task4.*;

/**
 * От пользователей приложения (см. задачу 4) пришел запрос
 * на возможность перемещать уже размеченные области.
 * 
 * Для поддержки новой функциональности вам требуется внести несколько
 * изменений:
 * 
 * 1) выбор аннотации по координатам точки (x, y);
 * В массиве аннотаций требуется найти первую, фигура которой содержит точку
 * с заданными координатами.
 * Annotation findByPoint(int x, int y) {
 * // ...
 * }
 * 
 * 2) выбор аннотации по шаблону подписи;
 * В массиве аннотаций требуется найти первую, подпись которой содержит заданную
 * подстроку.
 * Annotation findByLabel(String label) {
 * // ...
 * }
 * Определить, содержит ли строка заданную подстроку, можно с помощью метода
 * contains(CharSequence s) класса String.
 * 
 * 3) перемещение фигуры выбранной аннотации на смещение (dx, dy);
 * В рамках этого изменения вы решили доработать классы фигур таким образом,
 * чтобы они реализовывали интерфейс
 * public interface Movable {
 * void move(int dx, int dy);
 * }
 * 
 * Доработайте классы и реализуйте соответствующие методы.
 * 
 */

public class Task5 {
    public static void main(String[] args) {
        Annotation a1 = new Annotation(new Circle(100, 100, 10), "Tree");
        Annotation a2 = new Annotation(new Rectangle(100, 100, 150, 200), "Car");
        Annotation a3 = new Annotation(new Rectangle(100, 100, 200, 200), "CarTop");
       
        Annotation testPoint = new Annotation(new Circle(0, 0, 5), "testPoint");
        Annotation testPointCircle = new Annotation(new Circle(3, 3, 3), "testPointCircle");
        
        Annotation testRectangle = new Annotation(new Rectangle(4, 1, 8, 3), "testRectangle");

        AnnotatedImage annotatedImage = new AnnotatedImage("purh", a3, a2, a1);

        System.out.println(FindBy.point(1, 1, a1,a2,a3, testPointCircle));
        System.out.println(FindBy.point(5, 2, a1,a2,a3, testRectangle));

    }
}
