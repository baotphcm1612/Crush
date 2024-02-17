package com.bravos2k5.services;

import com.bravos2k5.daos.AccountDAO;
import com.bravos2k5.models.Account;
import com.bravos2k5.utils.EncryptPassword;
import com.bravos2k5.utils.Regex;

public class AccountService {

    public static final int WEAK_PASS = 0;
    public static final int OLD_PASS_NOT_CORRECT = 1;
    public static final int SUCCESS = 2;
    public static final int FAILED = 3;

    public static int updateAccountInfo(Account account) {
        if(AccountDAO.getInstance().update(account)) {
            return SUCCESS;
        }
        else {
            return FAILED;
        }
    }

    public static int changePassword(Account account, String oldPass, String newPass) {
        try {
            Account tmp = AccountDAO.getInstance().selectByUsername(account);
            if(EncryptPassword.checkPassword(oldPass,tmp.getPassword()) && Regex.isStrongPassword(newPass)) {
                tmp.setPassword(EncryptPassword.hashPassword(newPass));
                AccountDAO.getInstance().update(tmp);
                return SUCCESS;
            }
            else if(!Regex.isStrongPassword(newPass)) {
                return WEAK_PASS;
            }
            else {
                return OLD_PASS_NOT_CORRECT;
            }
        } catch (Exception e) {
            return FAILED;
        }
    }

}
