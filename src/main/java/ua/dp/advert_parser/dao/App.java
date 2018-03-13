package ua.dp.advert_parser.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.dp.advert_parser.core.Parser;
import ua.dp.advert_parser.dao.entity.Advert;
import ua.dp.advert_parser.dao.entity.Search;


import java.util.Set;

/**
 * Created by Denis Berezanskiy on 12.03.2018.
 */
public class App
{
    public static void main(String[] args) {

        String urlExample = "https://www.olx.pl/praca/informatyka/";
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Parser parser = new Parser();
        Set<String> links = parser.parsePage(urlExample);
        Transaction transaction = session.beginTransaction();
        Search search = new Search(urlExample);
        session.save(search);
        for(String url: links)
        {
            System.out.println(url);
            Advert advert = parser.parseAdvert(search,url);
            //TODO: Add check for existing advert in db
                    session.save(advert);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
    }




}
