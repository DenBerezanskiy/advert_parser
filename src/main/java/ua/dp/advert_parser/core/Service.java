package ua.dp.advert_parser.core;

import org.hibernate.exception.ConstraintViolationException;
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
import java.sql.SQLIntegrityConstraintViolationException;
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

    @Scheduled(fixedRate = 30000)
    @Transactional
    public void findAdverts()
    {
        String searchLink = "https://www.olx.ua/nedvizhimost/kvartiry-komnaty/dnepr/";
        advert = new Advert();
        Search search = null;
        Query checkUniquenessQuery = entityManager.createQuery("from Search where searchLink = '"+searchLink+"'");
        List resultList = checkUniquenessQuery.getResultList();
        if(resultList.size() != 0)
        {
            search = (Search)resultList.get(0);
        }
        else
        {
            search = new Search(searchLink);
            entityManager.persist(search);
        }
        Elements elements = parser.parsePage(searchLink);

        for(Element element:elements)
        {
            advert = parser.parseAdvert(element,search);

             checkUniquenessQuery = entityManager.createQuery("from Advert where url = :link");
            checkUniquenessQuery.setParameter("link", advert.getUrl());

             resultList = checkUniquenessQuery.getResultList();

            if (resultList.size() == 0 && resultList != null) {


                    if(advert.getUrl() != null && advert.getTitle() != null && advert.getPrice() != null)
                    {
                        System.out.println(advert);
                        entityManager.persist(advert);
                    }


            }
        }
        System.out.println("findAdverts() method executed at :" + new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));
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
        System.out.println("sendAdverts() method executed at :" + new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));
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
