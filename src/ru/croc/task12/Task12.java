package ru.croc.task12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Небольшой стартап разрабатывает социальный сервис, 
 * в котором пользователи могут оставлять комментарии. 
 * Со временем в комментариях появился спам и разработчики решили бороться с ним 
 * с помощью "черных списков" запрещенных слов. Они составили такие списки 
 * и поручили вам написать функцию, удаляющую из всех накопленных комментариев нежелательные.
 * 
 * 
 * Реализуйте интерфейс BlackListFilter.
 * В методе main покажите вариант использования вашего фильтра.
 * 
 * Доп сложности:
 * 1) Надо не удалить комментарий, а заменить грязные слова на звёздочки.
 * 2) Если слово написано с одной опечаткой - его также замаскировать

 */
public class Task12 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One, comment in, list one 1");
        list.add("Two comment in list two 2");
        list.add("Three comment in list three 3");
        list.add("Four comment in list four 4");
        list.add("Five comment in list five 5");


        Set<String> set = new HashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");

        Filter filter = new Filter();
        filter.filterComments(list, set);

    }
    
}
