package ru.job4j.bank;

import java.util.Objects;

/**
 * Описывает поведение пользователя
 */
public class User {
    /**
     * Пасспорт пользователя
     */
    private String passport;
    /**
     * Имя пользователя
     */
    private String username;

    /**
     * Создаёт нового пользователя
     * @param passport Пасспорт пользователя
     * @param username Имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * @return Возвращает пасспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Позволяет изменить пасспорт пользователя
     * @param passport Новый пасспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return Возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Позволяет изменить имя пользователя
     * @param username Новое имя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает по полю passport
     * @param o Объект для сравнения
     * @return true если паспорта идентичны и false в обратном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * @return Возвращает hashcode поля passport
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}