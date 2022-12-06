package ru.croc.task14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Нет единого способа представления комментариев среди сервисов:
 * где-то они представлены строками, где-то объектами специализированных
 * классов.
 * Вдобавок некоторым сервисам оказалось неудобным передавать набор комментариев
 * на фильтрацию
 * в виде списка и предпочтительнее коллекция другого типа.
 * 
 * реализовать единый метод фильтрации, учитывающий все обнаруженные
 * особенности.
 * В ходе анализа кода вы отмечаете для себя следующее:
 * 
 * 1. Условия фильтрации в разных сервисах различаются и нет возможности
 * обобщить их в рамках одного метода.
 * Поэтому способ фильтрации вы решаете представлять в виде предиката
 * 
 * 2. Набор используемых сервисами классов-представлений для комментариев
 * обширен
 * (String, Comment, CommentDto, …) и, возможно, будет и в дальнейшем
 * расширяться.
 * 
 * 3. Сервисы работают с наборами комментариев в виде коллекций разных типов
 * (HashSet, ArrayList, ArrayDeque, …), но все они имплементируют интерфейс
 * Iterable.
 * 
 * 4. Результат фильтрации удобнее представлять в виде отдельной
 * коллекции-возвращаемого значения метода,
 * а исходную коллекцию при этом не модифицировать.
 * Некоторым сервисам важен порядок следования комментариев,
 * поэтому он должен быть сохранен в отфильтрованном результате.
 * 
 * Обновите интерфейс BlackListFilter и реализуйте новый механизм фильтрации в
 * виде default-метода.
 */
public class Task14 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("One, comment in, list one 1");
        list.add("Two comment in list two 2!");
        list.add("Three comment in list three 3");
        list.add("Four comment in list four 4");
        list.add("test comment in list test 5");
        list.add("Five comment in list five 5");

        Set<String> set = new HashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");

        Predicate<String> predicate = comment -> {
            String[] words = comment.toLowerCase().split(" ");
            for (String w : words) {
                if (set.contains(w)) {
                    return true;
                }
            }
            return false;
        };

        BlackListFilter<String> filter = new BlackListFilter<>() {};
        List<String> result = (List<String>) filter.filterComments(list, predicate);
        for (String str : result) {
            System.out.println(str);
        }

    }
}
