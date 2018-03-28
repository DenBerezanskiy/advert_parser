package ua.dp.advert_parser.core;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.advert_parser.Application;
import ua.dp.advert_parser.dao.entity.Advert;
import ua.dp.advert_parser.dao.entity.Search;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Denis Berezanskiy on 27.03.2018.
 */
public class Service
{
    private Parser parser;
    private Advert advert;
    @PersistenceContext
    private EntityManager entityManager;




    @Transactional
    public void findAdverts(String searchLink)
    {
        advert = new Advert();
        Search search = new Search(searchLink);
        Elements elements = parser.parsePage(searchLink);

        for(Element element:elements)
        {
            advert = parser.parseAdvert(element,search);

            Query checkUniquenessQuery = entityManager.createQuery("from Advert where url = :link");
            checkUniquenessQuery.setParameter("link", advert.getUrl());

            List resultList = checkUniquenessQuery.getResultList();

            if (resultList.size() == 0 && resultList != null) {
                System.out.println(advert);
                entityManager.persist(advert);
            }
        }
    }
    @Scheduled(fixedRate = 30000)
    @Transactional
    public void sendAdverts()
    {
        Query query = entityManager.createQuery("from Advert where sent = 0");
        List<Advert> result = query.getResultList();
        for(Advert advert: result)
        {
            //TODO : Implement sending
            entityManager.createQuery("update Advert set sent = 1 where url = '"+advert.getUrl()+"'").executeUpdate();

        }

        System.out.println("Method executed at :" + new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));
    }
    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public Parser getParser() {
        return parser;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setSearchLink(String searchLink) {
    }
}
