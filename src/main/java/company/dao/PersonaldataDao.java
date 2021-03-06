package company.dao;

import company.hibernate.PersonaldataEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import company.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class PersonaldataDao {

    private Session session;

    public PersonaldataEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        PersonaldataEntity res = (PersonaldataEntity) session.get(PersonaldataEntity.class, id);
        session.close();
        return res;
    }

    public void save(PersonaldataEntity personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(personaldata);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void delete(PersonaldataEntity personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(personaldata);
        session.flush();
        tx1.commit();
        session.close();
    }

    public void update(PersonaldataEntity personaldata) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(personaldata);
        session.flush();
        tx1.commit();
        session.close();
    }

    public List<PersonaldataEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<PersonaldataEntity> res = (List<PersonaldataEntity>) session.createQuery("From PersonaldataEntity").list();
        session.close();
        return res;
    }

}
