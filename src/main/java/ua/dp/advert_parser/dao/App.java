package ua.dp.advert_parser.dao;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.dp.advert_parser.core.Parser;
import ua.dp.advert_parser.dao.entity.Advert;
import ua.dp.advert_parser.dao.entity.Search;


import java.util.List;


/**
 * Created by Denis Berezanskiy on 12.03.2018.
 */
public class App {
    public static void main(String[] args) {

        String urlExample = "https://www.olx.ua/transport/legkovye-avtomobili/dnepr/";
        AdvertDaoImpl daoImpl = new AdvertDaoImpl();
        Parser parser = new Parser();
        Elements elements = parser.parsePage(urlExample);

        daoImpl.openCurrentSession();

        Transaction transaction = daoImpl.getCurrentSession().beginTransaction();
        Search search = new Search(urlExample);
        daoImpl.getCurrentSession().save(search);

        for (Element element: elements) {
            String url = element.getElementsByAttributeValueContaining("class","detailsLink").attr("href");
            Query checkUniquenessQuery = daoImpl.getCurrentSession().createQuery("from Advert where url = :urls");
            checkUniquenessQuery.setParameter("urls", url);

            List resultList = checkUniquenessQuery.list();

            if (resultList.size() == 0 && resultList != null) {
                Advert advert = parser.parseAdvert(element, search);
                daoImpl.save(advert);
                System.out.println(advert);
            }
        }
        transaction.commit();
        daoImpl.closeCurrentSession();
    }


}
