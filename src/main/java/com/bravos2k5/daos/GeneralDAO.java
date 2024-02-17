package com.bravos2k5.daos;

import com.bravos2k5.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public interface GeneralDAO<T> {
    public List<T> selectAll();

    public T selectById(T variable);

    default boolean insert(T variable) {
        try {
            Session session = HibernateUtil.getSession();
            assert session != null;
            Transaction tr = session.beginTransaction();
            session.persist(variable);
            tr.commit();
            HibernateUtil.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    default boolean update(T variable) {
        try {
            Session session = HibernateUtil.getSession();
            assert session != null;
            Transaction tr = session.beginTransaction();
            session.merge(variable);
            tr.commit();
            HibernateUtil.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    default boolean delete(T variable) {
        try {
            Session session = HibernateUtil.getSession();
            assert session != null;
            Transaction tr = session.beginTransaction();
            session.remove(variable);
            tr.commit();
            HibernateUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
