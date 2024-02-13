package com.bravos2k5;

import com.bravos2k5.daos.AccountDAO;
import com.bravos2k5.graphics.Frame;
import com.bravos2k5.models.Account;
import com.bravos2k5.services.Personal;

import javax.swing.*;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Account account = AccountDAO.getInstance().selectByUsername(new Account("admin"));
        System.out.println(Personal.changePassword(account,"16122005viP@","BaoSQL2005@"));
    }
}
