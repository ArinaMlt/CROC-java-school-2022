package ru.croc.task4;
/**
 * Предположим, вы принимаете участие в разработке небольшого приложения по аннотированию 
 * (разметке) изображений с целью последующего использования этой разметки 
 * для обучения моделей computer vision. 
 * В этом приложении пользователь может выделять области на изображении с помощью прямоугольников
 *  и окружностей и подписывать их произвольным текстом.
 * Вся разметка для изображения представляется массивом Annotation[].
 * 
 */
public class Task4 {

    public static void main(String[] args) {

        Annotation a1 = new Annotation(new Circle(100, 100, 10), "Tree");
        Annotation a2 = new Annotation(new Rectangle(100, 100, 150, 200), "Car");
        System.out.println(a1);
        System.out.println(a2);

    }
}