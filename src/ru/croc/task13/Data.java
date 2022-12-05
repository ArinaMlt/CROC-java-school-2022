package ru.croc.task13;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public final class Data {
    private Data() {
    }

    private static List<Film> films = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    public static List<Film> getFilms() {
        return new ArrayList<>(films);
    }

    public static List<Film> films() {
        // List<Film> films = new ArrayList<>();
        Film film;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(
                "/Users/arina/Downloads/CodeProjects/CROC-java-school-2022/src/ru/croc/task13/films.txt"))) {
            String s;

            while ((s = reader.readLine()) != null) {
                String[] arrayS = s.split(",");
                Integer i = Integer.valueOf(arrayS[0]);
                film = new Film(i, arrayS[1]);
                films.add(film);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // System.out.println(films); // FOR TEST!!!!
        return films;
    }

    public static List<User> users() {
        // пользователи
        // List<User> users = new ArrayList<>();
        Film film;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(
                "/Users/arina/Downloads/CodeProjects/CROC-java-school-2022/src/ru/croc/task13/out.txt"))) {
            String s;
            int i = 0; // коэффициент для уникального идентификатора пользователя
            User user;
            while ((s = reader.readLine()) != null) {
                String[] splLine = s.split(",");
                List<Film> views = new ArrayList<>();
                for (String s1 : splLine) {
                    for (Film f : films) {
                        if (f.getId().equals(Integer.valueOf(s1))) {
                            film = f;
                            views.add(film);
                        }
                    }
                }
                user = new User(i, views);
                users.add(user);
                i++;
            }
            // users.forEach(System.out::println);// FOR TEST!!!!
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }

}
