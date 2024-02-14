package com.bravos2k5.daos;

import com.bravos2k5.models.Person;
import com.bravos2k5.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonDAO implements GeneralDAO<Person> {

    private static PersonDAO e;

    public static PersonDAO getInstance() {
        if(e == null) {
            e = new PersonDAO();
        }
        return e;
    }

    @Override
    public List<Person> selectAll() {
        Session session = HibernateUtil.getSession();
        assert session != null;
        Transaction tr = session.beginTransaction();
        String hql = "from Person";
        Query<Person> query = session.createQuery(hql, Person.class);
        List<Person> personList = query.getResultList();
        tr.commit();
        HibernateUtil.close();
        return personList;
    }

    @Override
    public Person selectById(Person variable) {
        Session session = HibernateUtil.getSession();
        assert session != null;
        Transaction tr = session.beginTransaction();
        Person person = session.get(Person.class,variable.getId());
        tr.commit();
        HibernateUtil.close();
        return person;
    }

    @Override
    public boolean insert(Person variable) {
        return false;
    }

    @Override
    public boolean update(Person variable) {
        return false;
    }

    @Override
    public boolean delete(Person variable) {
        return false;
    }
}
