package com.bravos2k5.daos;

import com.bravos2k5.models.User;
import com.bravos2k5.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO implements GeneralDAO<User> {

    private static UserDAO e;

    public static UserDAO getInstance() {
        if(e == null) {
            e = new UserDAO();
        }
        return e;
    }

    @Override
    public List<User> selectAll() {
        Session session = HibernateUtil.getSession();
        assert session != null;
        Transaction tr = session.beginTransaction();
        String hql = "from User";
        Query<User> query = session.createQuery(hql, User.class);
        List<User> personList = query.getResultList();
        tr.commit();
        HibernateUtil.close();
        return personList;
    }

    @Override
    public User selectById(User variable) {
        Session session = HibernateUtil.getSession();
        assert session != null;
        Transaction tr = session.beginTransaction();
        User person = session.get(User.class,variable.getId());
        tr.commit();
        HibernateUtil.close();
        return person;
    }
}
