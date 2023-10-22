package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += start.isBlank() ? el : "/" + el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> organisations) {
        organisations.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
    orgs.sort(new DepDescComp());
    }
}