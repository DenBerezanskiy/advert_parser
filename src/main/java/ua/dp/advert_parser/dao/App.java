package ua.dp.advert_parser.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.dp.advert_parser.core.Parser;
import ua.dp.advert_parser.dao.entity.Advert;
import ua.dp.advert_parser.dao.entity.Search;


import java.util.List;
import java.util.Set;

/**
 * Created by Denis Berezanskiy on 12.03.2018.
 */
public class App {
    public static void main(String[] args) {

        String urlExample = "https://www.olx.ua/transport/legkovye-avtomobili/dnepr/";
        AdvertDaoImpl daoImpl = new AdvertDaoImpl();
        Parser parser = new Parser();
        Set<String> links = parser.parsePage(urlExample);

        daoImpl.openCurrentSession();

        Transaction transaction = daoImpl.getCurrentSession().beginTransaction();
        Search search = new Search(urlExample);
        daoImpl.getCurrentSession().save(search);

        for (String url : links) {
            System.out.println(url);
            Query checkUniquenessQuery = daoImpl.getCurrentSession().createQuery("from Advert where url = :urls");
            checkUniquenessQuery.setParameter("urls", url);

            List resultList = checkUniquenessQuery.list();

            if (resultList.size() == 0 && resultList != null) {
                Advert advert = parser.parseAdvert(search, url);
                daoImpl.save(advert);
                System.out.println(advert);
            }
        }
        transaction.commit();
        daoImpl.closeCurrentSession();
    }


}
