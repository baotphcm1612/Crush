package com.bravos2k5.daos;

import com.bravos2k5.models.Team;
import com.bravos2k5.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TeamDAO implements GeneralDAO<Team>{

    private static TeamDAO e;

    public static TeamDAO getInstance() {
        if(e == null) {
            e = new TeamDAO();
        }
        return e;
    }

    @Override
    public List<Team> selectAll() {
        Session session = HibernateUtil.getSession();
        assert session != null;
        Transaction tr = session.beginTransaction();
        String hql = "from Team";
        Query<Team> query = session.createQuery(hql, Team.class);
        List<Team> list = query.getResultList();
        tr.commit();
        HibernateUtil.close();
        return list;
    }

    @Override
    public Team selectById(Team variable) {
        Session session = HibernateUtil.getSession();
        assert session != null;
        Transaction tr = session.beginTransaction();
        Team team = session.get(Team.class,variable.getId());
        tr.commit();
        HibernateUtil.close();
        return team;
    }
}
