package com.bravos2k5.daos;

import com.bravos2k5.models.Love;
import com.bravos2k5.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LoveDAO implements GeneralDAO<Love> {

    private static LoveDAO e;

    public static LoveDAO getInstance() {
        if(e == null) {
            e = new LoveDAO();
        }
        return e;
    }
    @Override
    public List<Love> selectAll() {
        Session session = HibernateUtil.getSession();
        assert session != null;
        Transaction tr = session.beginTransaction();
        String hql = "from Love";
        Query<Love> query = session.createQuery(hql, Love.class);
        List<Love> list = query.getResultList();
        tr.commit();
        HibernateUtil.close();
        return list;
    }

    @Override
    public Love selectById(Love variable) {
        Session session = HibernateUtil.getSession();
        assert session != null;
        Transaction tr = session.beginTransaction();
        Love love = session.get(Love.class,variable.getId());
        tr.commit();
        HibernateUtil.close();
        return love;
    }
}
