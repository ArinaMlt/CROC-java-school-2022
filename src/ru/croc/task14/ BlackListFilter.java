package ru.croc.task14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

interface BlackListFilter<T> {
    default Collection<T> filterComments(Iterable<T> comments, Predicate<T> blackList) {
        Collection<T> result = new ArrayList<>();
        for (T comment : comments) {
            if (!blackList.test(comment)) {
                result.add(comment);
            }
        }
        return result;
    }
}
