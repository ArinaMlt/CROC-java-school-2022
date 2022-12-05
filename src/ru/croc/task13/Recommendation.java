package ru.croc.task13;

import java.util.*;

public class Recommendation {
    private List<Film> films = Data.getFilms();
    private List<User> users = Data.users();

    private User user;

    public Recommendation(User user) {
        this.user = user;
    }


    public void recomend() {

        // сэт фильмов для рекмендации пользователю
        List<Film> movies = new ArrayList<>();

        // найти пользователей с >=50% совпадением фильмов
        for (User u : users) {
            int index = 0;
            int size = u.getViews().size();
            List<Film> usersViews = u.getViews();
            for (Film f : user.getViews()) {
                if (usersViews.contains(f)) {
                    index++;
                    // System.out.println("index: " + index + " film: " + f + " user " + u); // TEST !!!!!
                }
            }

            // записать подходящие просмотры пользователелй
            if (((index * 100) / size) >= 50) {
                // System.out.println("UsER SAVE: " + u); // TEST !!!!!
                for (Film i : usersViews) {
                    if (movies.indexOf(i) == -1) {
                        movies.add(i);
                    }
                }
            }
        }

        // System.out.println(movies); // TEST !!!!!


        // удалить из списка все фильмы, которые пользователь уже видел
        for (Film view : user.getViews()) {
            if (movies.indexOf(view) != -1) {
                movies.remove(view);
            }
        }

        // посчитать суммарное число просмотров среди всех пользователей
        Map<Film, Integer> recomendation = new HashMap<>();
        Integer key;
        for (User u : users) {
            List<Film> userviews = u.getViews();
            for (Film f : movies) {
                if (userviews.contains(f)) {
                    if ((key = recomendation.get(f)) != null) {
                        key++;
                        recomendation.put(f, key);
                    } else {
                        recomendation.put(f, 1);
                    }
                }
            }
        }

        // System.out.println("movies " + movies);// TEST !!!!!

        // System.out.println("recomendation: " + recomendation);// TEST !!!!!

        int maxValueInMap = (Collections.max(recomendation.values()));

        // System.out.println("max: " + maxValueInMap);// TEST !!!!!

        Film result = null;
        for (java.util.Map.Entry<Film, Integer> entry : recomendation.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                result = entry.getKey();
            }
        }

        System.out.println("Рекомендуем следующий фильм: " + result);

    }
}
