package com.bravos2k5.services;

import com.bravos2k5.daos.AccountDAO;
import com.bravos2k5.models.Account;

import javax.swing.*;

public class Personal {

    public static final byte WEAK_PASS = 0;
    public static final byte OLD_PASS_NOT_CORRECT = 1;
    public static final byte CHANGE_SUCCESS = 2;
    public static void updateAccountInfo(Account account) {
        AccountDAO.getInstance().update(account);
    }

    public static byte changePassword(Account account, String oldPass, String newPass) {
        Account tmp = AccountDAO.getInstance().selectByUsername(account);
        if(EncryptPassword.checkPassword(oldPass,tmp.getPassword()) && Regex.isStrongPassword(newPass)) {
            tmp.setPassword(EncryptPassword.hashPassword(newPass));
            AccountDAO.getInstance().update(tmp);
            return CHANGE_SUCCESS;
        }
        else if(!Regex.isStrongPassword(newPass)) {
            return WEAK_PASS;
        }
        else {
            return OLD_PASS_NOT_CORRECT;
        }
    }

    public static void forgetPassword() {
        //
    }
}
