package com.bravos2k5.services;

import com.bravos2k5.daos.AccountDAO;
import com.bravos2k5.daos.UserDAO;
import com.bravos2k5.models.Account;
import com.bravos2k5.models.User;

public class UserService {
    public static void createUser(Account account, User user) {
        user.setAccount(account);
        account.getUserList().add(user);
        UserDAO.getInstance().insert(user);
        AccountDAO.getInstance().update(account);
    }

    public static boolean deleteUser(User user) {
        try {
            user.getAccount().getUserList().remove(user);
            AccountDAO.getInstance().update(user.getAccount());
            UserDAO.getInstance().update(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean addFriend(User user1, User user2) {
        try {
            if (user1.getFriend().add(user2) && user2.getFriend().add(user1)) {
                UserDAO.getInstance().update(user1);
                UserDAO.getInstance().update(user2);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteFriend(User user1, User user2) {
        if(user1.getFriend().remove(user2) && user2.getFriend().remove(user1)) {
            UserDAO.getInstance().update(user1);
            UserDAO.getInstance().update(user2);
            return true;
        }
        return false;
    }

    public static boolean setLove(User user1, User user2) {
        if(user1.getLover() == null && user2.getLover() == null) {
            try {
                user1.setLover(user2);
                user2.setLover(user1);
                user1.setStatus(User.DATING);
                user2.setStatus(User.DATING);
                UserDAO.getInstance().update(user1);
                UserDAO.getInstance().update(user2);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
