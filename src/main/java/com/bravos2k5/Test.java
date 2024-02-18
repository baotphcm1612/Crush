package com.bravos2k5;

import com.bravos2k5.utils.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        HibernateUtil.getSession();
        HibernateUtil.close();
    }
}
