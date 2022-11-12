package ru.croc.task4;

public class AnnotatedImage {
    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    /**
     * 1) выбор аннотации по координатам точки (x, y);
     * В массиве аннотаций требуется найти первую,
     * фигура которой содержит точку с заданными координатами.
     * 
     * @return аннотация с заданными координатами / null - если нет в массиве.
     */
    public Annotation findByPoint(int x, int y) {
        Annotation result = null;
        for (int i = 0; i < annotations.length; i++) {
            boolean a = annotations[i].getFigure().point(x, y);
            if (a)
                return annotations[i];
        }
        return result;
    }

    /**
     * 2) выбор аннотации по шаблону подписи;
     * В массиве аннотаций требуется найти первую,
     * подпись которой содержит заданную подстроку.
     * 
     * @return аннтация по шаблону / null - если нет в массиве.
     */
    public Annotation findByLabel(String label) {
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i].getName().contains(label)) {
                return annotations[i];
            }
        }
        return null;
    }

}
