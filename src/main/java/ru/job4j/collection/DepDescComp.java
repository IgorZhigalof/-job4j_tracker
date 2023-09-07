package ru.job4j.collection;

import java.util.Comparator;
public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] splitO1 = o1.split("/");
        if (o2.startsWith(splitO1[0])) {
            return o1.compareTo(o2);
        }
        return o2.compareTo(o1);
    }
}