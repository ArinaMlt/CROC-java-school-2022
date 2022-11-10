package ru.croc.task6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * В текстах программ на Java могут использоваться многострочные
 * и однострочные (// ...) комментарии.
 * 
 * Реализовать метод, принимающий на вход строковую переменную - исходный текст
 * программы на Java,
 * вырезающий из этой строки все комментарии и возвращающий результат в виде
 * строки.
 * 
 * Можно задать source строку так, как в примере ниже или прочитать из файла.
 */
public class Task6 {
    public static void main(String[] args) {

        String result = "";
        boolean flag = true;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(
                "/Users/arina/Downloads/CodeProjects/CROC-java-school-2022/src/ru/croc/task6/in.txt"))) {

            String s;
            while ((s = reader.readLine()) != null) {

                if (s.length() > 0) {
                    for (int i = 0; i < s.toCharArray().length; i++) {
                        char[] c = s.toCharArray();
                        if (flag) {
                            if (c[i] == '/') {
                                if (c[i + 1] == '/') {
                                    result = result + "\n";
                                    break;
                                }
                                if (c[i + 1] == '*') {
                                    i++;
                                    flag = false;
                                }
                            } else {
                                result = result + c[i];
                            }
                        } else {
                            if (c[i] == '/') {
                                flag = true;
                            }
                        }
                    }

                } else {
                    result = "\n";
                }

                File file = new File(
                        "/Users/arina/Downloads/CodeProjects/CROC-java-school-2022/src/ru/croc/task6/out.txt");

                try (FileWriter writer = new FileWriter(file, false)) {
                    writer.write(result);
                    writer.flush();
                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
