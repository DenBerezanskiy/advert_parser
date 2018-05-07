package ua.dp.advertParser.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import ua.dp.advertParser.dao.entity.Advert;
import ua.dp.advertParser.dao.entity.Search;

/**
 * Created by Denis Berezanskiy on 27.03.2018.
 */
<<<<<<< HEAD
=======

//TODO: Logger
>>>>>>> mvc_impl
public class Parser
{
    private Advert advert;
    
<<<<<<< HEAD
    /***
     * The method below -
     * @param url - search link ,obtained from UI input.
     * @return Elements of offers table from olx
     */
=======
>>>>>>> mvc_impl
    public Elements parsePage(String url)
    {
        Document doc = null;
        Elements elements = null;
        
        try
        {
            doc = Jsoup.connect(url).get();
            elements = doc.getElementsByAttributeValue("class", "offer");
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return elements;
    }
    
<<<<<<< HEAD
    /**
     * @param element - html element that contains offer box details.
     * @param search  - Url entity ,who obtained from UI input.
     * @return Advert entity
     */
=======
>>>>>>> mvc_impl
    public Advert parseAdvert(Element element, Search search)
    {
        advert = new Advert();
        advert.setSearch(search);
        
        if (element != null)
        {
<<<<<<< HEAD
            // Todo: Please check what you really need to get all elements with "detailsLink, price and _a_"
=======
            // TODO: Please check what you really need to get all elements with "detailsLink, price and _a_"
>>>>>>> mvc_impl
            // Instead of it you can use '.get(0)' for the first occurrence
            
            Elements detailsLinkElements = element.getElementsByAttributeValueContaining("class", "detailsLink");
            
            if (detailsLinkElements != null && detailsLinkElements.hasAttr("href"))
            {
                String url = detailsLinkElements.attr("href");
                advert.setUrl(url);
            }
            
            Elements hrefElements = element.getElementsByTag("a");
            
            if (hrefElements != null && hrefElements.text() != null)
            {
                String title = hrefElements.text();
                advert.setTitle(title);
            }
            
            Elements priceElements = element.getElementsByAttributeValue("class", "price");
            
            if (priceElements != null && priceElements.text() != null)
            {
                String price = priceElements.text();
                advert.setPrice(price);
            }
        }
        
        return advert;
    }
    
    public void setAdvert(Advert Advert)
    {
        advert = Advert;
    }
    
    public Advert getAdvert()
    {
        return advert;
    }
}
