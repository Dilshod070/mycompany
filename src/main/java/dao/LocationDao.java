package dao;

import hibernate.LocationEntity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class LocationDao {

    private Session session;

    public LocationEntity findById(int id) {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        LocationEntity res = session.get(LocationEntity.class, id);
        session.close();
        return res;
    }

    public void save(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(location);
        tx1.commit();
        session.close();
    }

    public void delete(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(location);
        tx1.commit();
        session.close();
    }

    public void update(LocationEntity location) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(location);
        tx1.commit();
        session.close();
    }

    public List<LocationEntity> findAll() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<LocationEntity> res = (List<LocationEntity>) session.createQuery("From LocationEntity").list();
        session.close();
        return res;
    }
}
