package com.bravos2k5.daos;

import com.bravos2k5.models.Friendship;
import com.bravos2k5.utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FriendshipDAO implements GeneralDAO<Friendship> {

    private static FriendshipDAO e;

    public static FriendshipDAO getInstance() {
        if(e == null) {
            e = new FriendshipDAO();
        }
        return e;
    }

    @Override
    public List<Friendship> selectAll() {
        try {
            Session session = HibernateUtil.getSession();
            assert session != null;
            Transaction tr = session.beginTransaction();
            String hql = "from Friendship";
            Query query = session.createQuery(hql,Friendship.class);
            List<Friendship> list = query.getResultList();
            tr.commit();
            HibernateUtil.close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Friendship selectById(Friendship variable) {
        try {
            Session session = HibernateUtil.getSession();
            assert session != null;
            Transaction tr = session.beginTransaction();
            Friendship friendship = session.get(Friendship.class,variable.getId());
            tr.commit();
            HibernateUtil.close();
            return friendship;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
