package ua.dp.advert_parser.core;

import org.junit.Before;
import org.junit.Test;
import ua.dp.advert_parser.dao.entity.Advert;
import ua.dp.advert_parser.dao.entity.Search;

import java.util.Set;

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
        Set<String> urls = parser.parsePage(urlExample);
        assertTrue("Parser did not find any advertisement.", urls.size() > 0);
        //TODO: Add more tests


    }

    @Test

    public void parseAdvert() throws Exception {
        Set<String> urls = parser.parsePage(urlExample);
        for (String url:urls)
        {
            Advert advert = parser.parseAdvert(search,url);
            assertNotNull(advert);
            System.out.println(advert);
            assertFalse("url is null",advert.getUrl()== null);
            assertFalse("title is null" ,advert.getTitle()== null );
            assertFalse("price is null" , advert.getPrice()== null);
            assertFalse("description is null" , advert.getDescription() == null);
        }


    }

}