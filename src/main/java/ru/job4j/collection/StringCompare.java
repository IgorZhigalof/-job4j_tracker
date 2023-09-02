package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int resultByLength = Integer.compare(left.length(), right.length());
        int board = resultByLength == 1 ? right.length() : left.length();
        for (int i = 0; i < board; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return Character.compare(left.charAt(i), right.charAt(i));
            }
        }
        return resultByLength;
    }
}