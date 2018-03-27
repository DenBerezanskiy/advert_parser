package ua.dp.advert_parser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.advert_parser.core.Parser;
import ua.dp.advert_parser.dao.entity.Advert;
import ua.dp.advert_parser.dao.entity.Search;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by Denis Berezanskiy on 27.03.2018.
 */

public class Application {
    private Parser parser;
    private static String searchLink;
    private Advert advert;
    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        System.out.println("Start");
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Context initialised");
        Application application =
                (Application)context.getBean("application");

        searchLink = "https://www.olx.ua/transport/legkovye-avtomobili/dnepr/";

            application.run(searchLink);
    }
    @Transactional
    public void run(String searchLink)
    {
        advert = new Advert();
        Search search = new Search(searchLink);
        Elements elements = parser.parsePage(searchLink);
        for(Element element:elements)
        {
          advert = parser.parseAdvert(element,search);

            System.out.println(advert);
            entityManager.persist(advert);
        }
    }
    public void setParser(Parser Parser) {
        parser = Parser;
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
}
