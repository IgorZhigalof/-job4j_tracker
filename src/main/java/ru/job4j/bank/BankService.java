package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Описывает работу основных операций с пользователями и счётами.
 */
public class BankService {
    /**
     * HashMap с обектами описывающими пользователей.
     * Чтобы добавить нового пользователя необходимо использовать метод addUser.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в базу данных.
     * @param user Пользователь для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из базы данных.
     * @param passport Пасспорт удалямого пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Привязывает счёт к пользователью.
     * @param passport Пасспорт пользователя
     * @param account Счёт для привязки
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
                users.put(user, accounts);
            }
        }
    }

    /**
     * Поиск пользователя по паспорту.
     * @param passport Пасспорт пользователя
     * @return Возвращяет пользователя или null если такового нет
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(x -> passport.equals(x.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Поиск счёта по реквизитам.
     * @param passport Пасспорт пользователя владеющего нужным счётом
     * @param requisite Номер нужного счёта
     * @return счёт или null если такого счёта или пользователя нет
     */
    public Account findByRequisite(String passport, String requisite) {
        User currentUser = findByPassport(passport);
        if (currentUser == null) {
            return null;
        }
        List<Account> accounts = users.get(currentUser);
        return accounts
                .stream()
                .filter(x -> requisite.equals(x.getRequisite()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Совершает перевод с одного счёта на другой.
     * @param srcPassport Пасспорт пользователя - владельца счёта с которого совершается перевод
     * @param srcRequisite Номер счёта с которого совершается перевод
     * @param destPassport Пасспорт пользователя - владельца счёта на который совершается перевод
     * @param destRequisite Номер счёта на который совершается перевод
     * @param amount Сумма перевода
     * @return Возвращает true в случае успешного перевода и false если перевод не удался
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account sourceAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if ((sourceAccount == null || destAccount == null) || (sourceAccount.getBalance() < amount)) {
            return false;
        }
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }

    /**
     * @param user Пользователь
     * @return Возвращает все счёта пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}