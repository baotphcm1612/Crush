package com.bravos2k5;

import com.bravos2k5.daos.AccountDAO;
import com.bravos2k5.daos.PersonDAO;
import com.bravos2k5.graphics.Frame;
import com.bravos2k5.models.Account;
import com.bravos2k5.models.Person;
import com.bravos2k5.services.Personal;

import javax.swing.*;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Person> personList = PersonDAO.getInstance().selectAll();
    }
}
