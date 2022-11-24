package ru.croc.task12;

import java.util.List;
import java.util.Set;

public class Filter implements BlackListFilter {

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        for (String line : comments) {
            String[] s = line.split("\\s");
            String result = "";
            for (String world : s) {
                String[] up = world.toLowerCase().split(",");
                if (!blackList.contains(up[0])) {
                    result = result + world + " ";
                } else {
                    int i = up[0].length();
                    String star = "*";
                    String z = star.repeat(i);
                    result = result + z + " ";
                }
            }
            comments.set(comments.indexOf(line), result);
        }
        for (String s1 : comments) {
            System.out.println(s1);
        }
    }

}
