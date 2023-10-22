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
        for (var person : this.persons) {
            if (person.getPhone().contains(key)
             || person.getName().contains(key)
             || person.getAddress().contains(key)
             || person.getSurname().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }

    public ArrayList<Person> finds(String key) {
        Predicate<Person> testPhone = x -> x.getPhone().contains(key);
        Predicate<Person> testName = x -> x.getName().contains(key);
        Predicate<Person> testAddress = x -> x.getAddress().contains(key);
        Predicate<Person> testSurname = x -> x.getSurname().contains(key);
        Predicate<Person> combine = testAddress.or(testName).or(testPhone).or(testSurname);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}