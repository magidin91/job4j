package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        users.get(findByPassport(passport)).add(account);
    }

    public User findByPassport(String passport) {
       return users.keySet().stream().filter(user->user.getPassport().equals(passport)).collect(Collectors.toList()).get(0);
    }

    public Account findByRequisite(String passport, String requisite) {
        return users.get(findByPassport(passport)).stream().filter(user->user.getRequisite().equals(requisite)).collect(Collectors.toList()).get(0);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        double srcBalance = findByRequisite(srcPassport, srcRequisite).getBalance();
        double destBalance = findByRequisite(destPassport, destRequisite).getBalance();
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcBalance >= amount) {
            srcAccount.setBalance(srcBalance - amount);
            destAccount.setBalance(destBalance + amount);
            rsl = true;
        }
        return rsl;
    }
}