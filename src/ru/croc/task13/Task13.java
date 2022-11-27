package ru.croc.task13;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Кинотеатр "Места для поцелуев" открыл стриминговый сервис для
 * онлайн-просмотра фильмов.
 * За несколько месяцев работы сервиса накопилась история просмотров разными
 * пользователями
 * и владельцы решили внедрить в него систему рекомендаций,
 * которая предлагала бы пользователям интересный фильм на основе их истории
 * просмотров.
 * 
 * У вас есть два файла (их тоже запушьте к себе в репозиторий, пожалуйста):
 * 
 * 1. Список доступных фильмов. Каждая строка содержит числовой идентификатор
 * фильма и его название,
 * разделенные запятой.
 * Например:
 * 1,Мстители: Финал
 * 2,Хатико
 * 3,Дюна
 * 4,Унесенные призраками
 * 
 * 
 * 2. История просмотров по всем пользователям сервиса.
 * Каждая строка файла содержит список идентификаторов фильмов,
 * просмотренных одним человеком за все время пользования сервисом.
 * Идентификаторы разделены запятыми.
 * Например:
 * 2,1,3
 * 1,4,3
 * 2,2,2,2,2,3
 * 
 * 
 * На основе этих данных реализуйте алгоритм рекомендаций,
 * который бы для списка просмотров конкретного пользователя рекомендовал
 * следующий фильм.
 * 
 * Алгоритм выбора рекомендации
 * 1. Для просмотров пользователя из историй по всем пользователям выбираются
 * те,
 * у которых хотя бы половина фильмов совпадает с заданной.
 * (То есть, выбираются все пользователи, которые посмотрели минимум половину
 * фильмов пользователя,
 * для которого формируется рекомендация.)
 * 2. Из отобранных списков исключаются все, которые пользователь уже посмотрел.
 * 3. Для оставшегося списка фильмов подсчитывается суммарное количество
 * просмотров
 * среди всех пользователей сервиса и фильм с максимальным числом просмотров
 * выбирается как рекомендация
 * (если таких фильмов оказалось несколько, выбирается любой из них).
 * 
 * Список просмотров текущего пользователя задается через пользовательский ввод,
 * рекомендация выдается в виде названия фильма в System.out. Пути к файлам с
 * названиями фильмов и истории просмотров пользователей сервиса могут быть
 * определены
 * в виде констант в приложении.
 */
public class Task13 {
    public static void main(String[] args) {

        // запись из файла в карту
        Map<Integer, String> films = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(
                "/Users/arina/Downloads/CodeProjects/CROC-java-school-2022/src/ru/croc/task13/films.txt"))) {
            String s;
            while ((s = reader.readLine()) != null) {
                String[] arrayS = s.split(",");
                Integer i = Integer.valueOf(arrayS[0]);
                films.put(i, arrayS[1]);
            }
            System.out.println(films);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // пользователи
        Map<Integer, ArrayList<Integer>> users = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(
                "/Users/arina/Downloads/CodeProjects/CROC-java-school-2022/src/ru/croc/task13/out.txt"))) {
            String s;
            int i = 0; // коэффициент для уникального идентификатора пользователя
            while ((s = reader.readLine()) != null) {
                String[] splLine = s.split(",");
                List<Integer> views = new ArrayList<>();
                for (String s1 : splLine) {
                    views.add(Integer.valueOf(s1));
                }
                users.put(i, (ArrayList<Integer>) views);
                i++;
            }
            System.out.println(users);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // пользователь вводит свои просмотры
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свой список фильмов: ");
        String user = scanner.nextLine();
        String[] userViewsSplit = user.replaceAll("\\s+", "").split(",");

        // просмотры пользователя
        ArrayList<Integer> userViews = new ArrayList<>();
        for (String s : userViewsSplit) {
            userViews.add(Integer.valueOf(s));
        }

        // сэт фильмов для рекмендации пользователю
        List<Integer> movies = new ArrayList<>();

        // найти пользователей с >=50% совпадением фильмов
        for (ArrayList<Integer> view : users.values()) {
            int index = 0;
            int size = view.size();// сколько фильмов посмотрел пользователь
            for (int i : userViews) {
                System.out.println("i:" + i);
                if (view.indexOf(i) != -1) {
                    index++;
                    System.out.println("index: " + index);
                }
            }

            // записать подходящие просмотры пользователелй
            if (((index * 100) / size) >= 50) {
                for (Integer i : view) {
                    if (movies.indexOf(i) == -1) {
                        movies.add(i);
                    }
                }
            }

        }

        System.out.println(movies);

        // удалить из списка все фильмы, которые пользователь уже видел
        for (Integer view : userViews) {
            if (movies.indexOf(view) != -1) {
                movies.remove(view);
            }
        }

        // посчитать суммарное число просмотров среди всех пользователей
        Map<Integer, Integer> recomendation = new HashMap<>();
        Integer key;
        for (ArrayList<Integer> view : users.values()) {
            for (Integer v : view) {
                for (Integer movie : movies) {
                    if (movie == v) {
                        if ((key = recomendation.get(movie)) != null) {
                            key++;
                            recomendation.put(v, key);
                        } else {
                            recomendation.put(v, 1);
                        }
                    }
                }
            }
        }

        System.out.println("movies " + movies);

        System.out.println("recomendation: " + recomendation);

        int maxValueInMap = (Collections.max(recomendation.values()));
        System.out.println("max: " + maxValueInMap);

        Integer result = 0;
        for (java.util.Map.Entry<Integer, Integer> entry : recomendation.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                result = entry.getKey();
            }
        }

        System.out.println("Рекомендуем следующий фильм: " + films.get(result));

    }

}
