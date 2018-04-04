package ua.dp.advertParser.core;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import ua.dp.advertParser.dao.entity.Advert;
import ua.dp.advertParser.dao.entity.Search;

import static org.junit.Assert.*;

/**
 * Created by Denis Berezanskiy on 12.03.2018.
 */
public class ParserTest {

    private String urlExample;
    private Parser parser;
    private Search search;

    @Before
    public void before() {
        urlExample = "https://www.olx.ua/nedvizhimost/kvartiry-komnaty/dnepr/";
        parser = new Parser();
        search = new Search(urlExample);
    }

    @Test
    public void parsePageTest() throws Exception {
        Elements elements = parser.parsePage(urlExample);
        assertFalse("Parser did not find any advertisement.", elements.size() == 0);
        //TODO: Add more tests


    }

    @Test

    public void parseAdvert() throws Exception {
        Elements elements = parser.parsePage(urlExample);
        for (Element element:elements)
        {
            Advert advert = parser.parseAdvert(element,search);
            assertNotNull(advert);
            System.out.println(advert);
            assertFalse("url is null",advert.getUrl()== null);
            assertFalse("title is null" ,advert.getTitle()== null );
            assertFalse("price is null" , advert.getPrice()== null);
        }


    }

}