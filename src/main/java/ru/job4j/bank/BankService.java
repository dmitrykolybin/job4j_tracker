package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу простейшего банка.
 * Позволяет:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 * @author Dmitry Kolybin
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех пользователей системы с привязанными к ним счетами.
     * осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     * @param user пользователь, который добавляется в систему.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя из системы по номеру его паспорта.
     * @param passport паспорт, по которому происходит удаление.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет новый счёт пользователю.
     * Если пользователь идентифицирован, и если такого счёта ещё нет,
     * тогда новый счёт будет добавлен.
     * @param passport паспорт, идентифицирующий пользователя.
     * @param account новый счёт, который будет добавлен пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод идентифицирует пользователя по его паспорту.
     * Осуществляется проход по списку users и сравнивается
     * паспорт пользователя и паспорт, данный в качестве входного параметра.
     * @param passport паспорт, по которому необходимо идентифицировать пользователя.
     * @return если пользователь найден, метод возвращает пользователя, иначе null.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * Сначала ищется пользователь по паспорту с помощью метода findByPassport.
     * Потом выводится список счетов этого пользователя и в нем ищется нужный счет.
     * @param passport паспорт пользователя, чей счёт нужно найти.
     * @param requisite риквизиты счёта, который нужно найти.
     * @return возвращает счёт, если он найдет. Иначе возвращает null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     * Сначала находятся счета отправителя и получателя.
     * Затем при идентификации счетов и средств на счёте отправителя осуществляется перевод.
     * @param sourcePassport паспорт отправителя
     * @param sourceRequisite реквизиты отправителя
     * @param destinationPassport паспорт получателя
     * @param destinationRequisite реквизиты получателя
     * @param amount количество денег, которые будут переведены
     * @return true, если перевод прошел успешно, иначе - false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null
                && destinationAccount != null
                && sourceAccount.getBalance() - amount >= 0) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод предназначен для проверки наличия счетов у пользователя.
     * Используется только в тестах.
     * @param user пользователь, чьи счета нужно вернуть.
     * @return возвращает счета пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}