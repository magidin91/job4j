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
        if (findByPassport(passport) != null) {
            users.get(findByPassport(passport)).add(account);
        }
    }

    public User findByPassport(String passport) {
        List<User> findUser = users.keySet().stream().filter(user -> user.getPassport().equals(passport)).collect(Collectors.toList());
        if (findUser.size() != 0) {
            return findUser.get(0);
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            List<Account> findAccount = users.get(findByPassport(passport)).stream().
                    filter(user -> user.getRequisite().equals(requisite)).collect(Collectors.toList());
            if (findAccount.size() != 0) {
                return findAccount.get(0);
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            double srcBalance = srcAccount.getBalance();
            double destBalance = destAccount.getBalance();
            if (srcBalance >= amount) {
                srcAccount.setBalance(srcBalance - amount);
                destAccount.setBalance(destBalance + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}