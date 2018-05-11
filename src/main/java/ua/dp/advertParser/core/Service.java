package ua.dp.advertParser.core;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import ua.dp.advertParser.bot.Bot;
import ua.dp.advertParser.dao.entity.Advert;
import ua.dp.advertParser.dao.entity.Search;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Denis Berezanskiy on 27.03.2018.
 */
//TODO: Logger
public class Service
{
    private Parser parser;
    private Advert advert;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * Method parse all newest ads and store it to DB.
     */
    private static String searchLink;
    
    @Scheduled(fixedRate = 30000)
    @Transactional
    public void findAdverts()
    {
    
        Query linkQuery = entityManager.createQuery("from Search where isActive = 0");
    
        List result = linkQuery.getResultList();
        if (!result.isEmpty())
        {
            Search search = (Search) result.get(0);
            searchLink = search.getSearchLink();
    
            advert = new Advert();
    
            if (searchLink != null || !searchLink.isEmpty())
            {
                Elements elements = parser.parsePage(searchLink);
        
                for (Element element : elements)
                {
                    advert = parser.parseAdvert(element, search);
            
                    Query checkUniquenessQuery = entityManager.createQuery("from Advert where url = :link");
                    checkUniquenessQuery.setParameter("link", advert.getUrl());
            
                    List resultList = checkUniquenessQuery.getResultList();
            
                    if (resultList.isEmpty())
                    {
                        if (advert.getUrl() != null && advert.getTitle() != null && advert.getPrice() != null)
                        {
                            entityManager.persist(advert);
                        }
                    }
                }
                System.out.println("findAdverts() method executed at :" + new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));
            }
        }
    }
    
    
    @Scheduled(fixedRate = 30000)
    @Transactional
    public void sendAdverts()
    {
        Query query = entityManager.createQuery("from Advert where sent = 0");
        
        List<Advert> result = query.getResultList(); // TODO: Unchecked assignment
        ArrayList<String> advertUrls = new ArrayList<>();
        
        if (result.isEmpty())
        {
            return;
        }
        for (Advert advert : result)
        {
            if (advert.getUrl() != null && advert.getPrice() != null && advert.getTitle() != null)
            {
                String url = advert.getUrl();
                new Bot().sendAdvertUrl(url);
                // sent value must be 0 by default , only after sending marker must be changed to 1.
                entityManager.createQuery("update Advert set sent = 1 where url = '" + advert.getUrl() + "'").executeUpdate();
            }
        }
        System.out.println("sendAdverts() method executed at :" + new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));
    }
    
    public void setParser(Parser parser)
    {
        this.parser = parser;
    }
    
    public Parser getParser()
    {
        return parser;
    }
    
    public void setAdvert(Advert advert)
    {
        this.advert = advert;
    }
    
    public Advert getAdvert()
    {
        return advert;
    }
    
    public static String getSearchLink()
    {
        return searchLink;
    }
    
    public static void setSearchLink(String searchLink)
    {
        Service.searchLink = searchLink;
    }
    
}
