package ru.croc.task15;

import java.util.*;

public class GroupsAge {
    private List<Integer> ages;
    private List<Person> allPeople;

    int agePerson;
    int zero;
    int size;
    Map<Integer, List<Person>> groups = new HashMap<>();

    public GroupsAge(List<Person> allPeople, List<Integer> ages) {
        this.allPeople = allPeople;
        this.ages = ages;
        size = ages.size() - 1;
        Integer last = ages.get(size);
        ages.add(last + 1);
        ages.add(0);
    }

    private void groupOfAge() {
        Collections.sort(ages);
        // для всех людей в списке
        size = ages.size();
        int last = ages.get(size - 1);
        zero = 0;
        for (Person p : allPeople) {

            agePerson = p.getAge();// возраст

            for (Integer i : ages) {
                if (agePerson > last) {
                    List<Person> people = groups.get(last);

                    if (people == null) {
                        people = new LinkedList<>();
                        groups.put(last, people);

                    }
                    people.add(p);
                    break;
                }
                if ((agePerson > zero) && (agePerson <= i)) {

                    List<Person> people = groups.get(i);

                    if (people == null) {
                        people = new LinkedList<>();
                        groups.put(i, people);

                    }
                    people.add(p);
                    break;
                }

                zero = i;
            }
        }
        sortList();
        Collections.reverse(ages);
    }

    private void sortList() {

        Collection<List<Person>> age = groups.values();
        for (List<Person> i : age) {
            Collections.sort(i, Person.COMPARE);
        }

    }

    @Override
    public String toString() {
        groupOfAge();

        // System.out.println(ages);
        int inde = 0;
        size = ages.size() - 1;
        for (Integer i : ages) {
            List<Person> person = groups.get(i);
            int index = ages.indexOf(i);
            if ((index == size - 1) && (person != null)) {
                System.out.print("\n" + 0 + " - " + i + ":");
                person.forEach(System.out::print);
            } else {
                if ((index == 0) && (person != null)) {
                    System.out.print("\n" + i + " + ");
                    person.forEach(System.out::print);
                } else {
                    if (person != null) {
                        int la = ages.get(inde + 1);
                        System.out.print("\n" + (la + 1) + " - " + i + ": ");
                        person.forEach(System.out::print);
                    }
                }
            }

            inde++;
        }

        return "";
    }

}
