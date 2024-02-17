package com.bravos2k5.services;

import com.bravos2k5.daos.AccountDAO;
import com.bravos2k5.daos.UserDAO;
import com.bravos2k5.models.Account;
import com.bravos2k5.models.User;

public class UserService {
    public static void createUser(Account account, User user) {
        user.setAccount(account);
        user.setStatus(User.SINGLE);
        account.getPersonList().add(user);
        if (user.getAccount().getId().equals(account.getId())) {
            UserDAO.getInstance().insert(user);
            AccountDAO.getInstance().update(account);
        }
    }

    public static boolean deleteUser(User user) {
        try {
            user.getAccount().getPersonList().remove(user);
            AccountDAO.getInstance().update(user.getAccount());
            UserDAO.getInstance().update(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
