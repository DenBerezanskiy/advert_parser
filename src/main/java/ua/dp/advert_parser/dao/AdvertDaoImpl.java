package ua.dp.advert_parser.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.dp.advert_parser.dao.AdvertDao;
import ua.dp.advert_parser.dao.entity.Advert;


import java.util.List;

/**
 * Created by Denis Berezanskiy on 21.03.2018.
 */
public class AdvertDaoImpl implements AdvertDao
{
    private Session currentSession;


    public AdvertDaoImpl(){}

    public Session openCurrentSession()
    {
        currentSession = getSessionFactory().openSession();

        return currentSession;
    }

    public void closeCurrentSession()
    {
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        return sessionFactory;
    }

    public Session getCurrentSession()
    {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession)
    {
        this.currentSession = currentSession;
    }

    @Override
    public void save(Advert advert)
    {
        getCurrentSession().save(advert);
    }
    @Override
    public List<Advert> getAllNotSent() {
        Session session = getCurrentSession();
        Query query = session.createQuery("from Advert where sent = 0");
        List<Advert> notSent = query.list();
        query = session.createQuery("update Advert set sent = 1 where sent = 0");
        query.executeUpdate();
        return notSent;
    }
}
