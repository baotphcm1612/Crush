package com.bravos2k5.services;

import com.bravos2k5.daos.AccountDAO;
import com.bravos2k5.models.Account;

import javax.swing.*;

public class LoginService {
    public static boolean Login(String username, String password) {
        Account tmp = new Account(username);
        Account account = AccountDAO.getInstance().selectByUsername(tmp);
        return EncryptPassword.checkPassword(password, account.getPassword());
    }

    public static void Register(String username, String password) {
        Account tmp = new Account(username);
        Account checkExist = AccountDAO.getInstance().selectByUsername(tmp);
        if(checkExist == null) {
            if(Regex.isStrongPassword(password)) {
                tmp.setPassword(EncryptPassword.hashPassword(password));
                tmp.setBan(false);
                AccountDAO.getInstance().insert(tmp);
                JOptionPane.showMessageDialog(null,"Register successful");
            }
            else {
                JOptionPane.showMessageDialog(null,password);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Username was existed!");
        }
    }




}
