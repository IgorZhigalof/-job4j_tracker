package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("igor.zhigalof@gmail.com", "Zhigalov Igor");
        hashMap.put("random.mail@gmail.com", "any info");
        hashMap.put("anotherrandommail@gmail.com", "any info");
        hashMap.put("igor.zhigalof@gmail.com", "Zhigalov Igor Olegovych");
        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
