package ru.croc.task15;

import java.util.*;

/**
 * Ваша команда разрабатывает приложение для проведения социологических опросов.
 * Вы работаете над модулем разбивки респондентов по возрастным группам.
 * При этом модуль вы реализуете в виде отдельного Java-приложения,
 * работающего со стандартными потоками ввода-вывода.
 * На вход (System.in) оно принимает список участников опроса в текстовом виде,
 * на выходе (System.out) выдает их разбивку по группам возрастов.
 * 
 * В качестве аргументов командной строки приложению указывается
 * последовательность чисел,
 * задающих границы возрастных групп.
 * 
 */
public class Task15 {
    public static void main(String[] args) {
        System.out.println("Введи возрастные группы: ");

        List<Person> allPeople = Arrays.asList(
                new Person("Кошельков Захар Брониславович", 105),
                new Person("Иванов Варлам Якунович", 88),
                new Person("Дьячков Нисон Иринеевич ", 88),
                new Person("Старостин Ростислав Ермолаевич", 50),
                new Person("Ярилова Розалия Трофимовна", 29),
                new Person("Егоров Алан Петрович", 7),
                new Person("Соколов Андрей Сергеевич", 15));
        // new Person("Егоров Алан Петрович", 7));

        List<Integer> ages = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] s1 = s.split(" ");

        for (String s2 : s1) {
            ages.add(Integer.valueOf(s2));
        }

        GroupsAge groupsAge = new GroupsAge(allPeople, ages);
        // groupsAge.groupOfAge();
        // groupsAge.sortList();
        System.out.println(groupsAge);

    }

}
