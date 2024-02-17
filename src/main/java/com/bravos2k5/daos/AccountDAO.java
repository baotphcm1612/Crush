package com.bravos2k5.daos;

import com.bravos2k5.models.Account;
import com.bravos2k5.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements GeneralDAO<Account> {

    private static AccountDAO e;
    public static AccountDAO getInstance() {
        if(e == null) {
            e = new AccountDAO();
        }
        return e;
    }
    @Override
    public List<Account> selectAll() {
        List<Account> accountList = null;
        try {
            Session session = HibernateUtil.getSession();
            assert session != null;
            Transaction tr = session.beginTransaction();
            String hql = "from Account";
            Query<Account> query = session.createQuery(hql,Account.class);
            accountList = query.getResultList();
            HibernateUtil.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return accountList;
    }

    @Override
    public Account selectById(Account variable) {
        try {
            Session session = HibernateUtil.getSession();
            assert session != null;
            Transaction tr = session.beginTransaction();
            Account account = session.get(Account.class,variable.getId());
            HibernateUtil.close();
            return account;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Account selectByUsername(Account variable) {
        try {
            Session session = HibernateUtil.getSession();
            assert session != null;
            Transaction tr = session.beginTransaction();
            String hql = "from Account a where a.username =:username";
            Query<Account> query = session.createQuery(hql,Account.class);
            query.setParameter("username",variable.getUsername());
            Account account = query.getSingleResultOrNull();
            HibernateUtil.close();
            return account;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
