package ru.croc.task9;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EnumerationRunnable implements Runnable {

    private static volatile boolean cancelled = false;

    public void cancel() {
            cancelled = true;
    }

    private String result;
    private String hash;

    public EnumerationRunnable(String result, String hash) {
        this.result = result;
        this.hash = hash;
    }

    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }

    @Override
    public void run() {
        // System.out.println(result);
        System.out.println(enumerate());

    }

    private String enumerate() {

        char[] c = result.toCharArray(); // преобразовать строчку в массив символов
        int size = c.length;

        int arr[] = new int[size]; // массив для хранения текущего варианта множества
        for (int i = 0; i < c.length; i++) {
            // arr[i] = 0;
            arr[i] = (int) c[i] - 97;
            c[i] = 'a';
        }

        outer: while (!cancelled) { // вечный цикл

            // проверить хэш
            if ((hashPassword(result).equals(hash.toUpperCase()))) {
                cancel();
                return result;
            }

            // вывод варианта множества на экран
            result = "";
            for (int i = 0; i < arr.length; i++) {
                result = result + (char) (c[i] + arr[i]);
            }

            // System.out.println(result);
            // System.out.println();

            int i = size - 1;// ставим курсов в самую правую ячейку
            while (arr[i] == 25) {// движемся влево, если ячейка переполнена
                arr[i] = 0;// записываем в ячейку 0, т.к. идет перенос разряда
                i--;// сдвиг влево
                // если перенос влево невозможен, значит перебор закончен
                if (i < 0)
                    break outer;
            }
            arr[i]++;// увеличиваем значение ячейки на единицу
        }
        return null;
    }

}
