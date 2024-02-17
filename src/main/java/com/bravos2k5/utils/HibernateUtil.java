package com.bravos2k5.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSession();

    private static SessionFactory buildSession() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            System.out.println("Build session failed!");
            throw new HibernateException(e);
        }
    }

    public static Session getSession() {
        SessionFactory session = sessionFactory;
        if(session != null) {
            return (Session) session.openSession();
        }
        return null;
    }

    public static void close() {
        assert getSession() != null;
        getSession().close();
    }
}
