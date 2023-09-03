package ru.job4j.bank;

import java.util.Objects;

/**
 * Описывает поведение счёта
 */
public class Account {
    /**
     * Описывает номер счёта
     */
    private String requisite;
    /**
     * Описывает баланс на счёте
     */
    private double balance;

    /**
     * Создаёт новый счёт
     * @param requisite Номер счёта
     * @param balance Начальный баланс на счёте
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * @return Возвращает номер счёта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Позволяет изменить номер счёта
     * @param requisite Новый номер счёта
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * @return Возвращает баланс на счёте
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Повзволяет изменить баланс на счёте
     * @param balance Новый баланс на счёте
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает по полю requisite
     * @param o Объект для сравнения
     * @return true если реквизиты идентичны и false в обратном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * @return Возвращает hashcode поля requisite
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}