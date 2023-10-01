package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if (person.getPhone().contains(key)
             || person.getName().contains(key)
             || person.getAddress().contains(key)
             || person.getSurname().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }

    private static boolean isCorrect(Person person, String key) {
        return person.getPhone().contains(key)
                || person.getName().contains(key)
                || person.getAddress().contains(key)
                || person.getSurname().contains(key);
    }

    public ArrayList<Person> finds(String key) {
        Predicate<Person> combine = (Person person) -> isCorrect(person, key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}