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


//TODO: Logger
public class Parser
{
    private Advert advert;
    
    /***
     * The method below -
     * @param url - search link ,obtained from UI input.
     * @return Elements of offers table from olx
     */
    
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
    
    /**
     * @param element - html element that contains offer box details.
     * @param search  - Url entity ,who obtained from UI input.
     * @return Advert entity
     */
    
    public Advert parseAdvert(Element element, Search search)
    {
        advert = new Advert();
        advert.setSearch(search);
        
        if (element != null)
        {
            Elements detailsLinkElements = element.getElementsByAttributeValueContaining("class", "linkWithHash detailsLink");
            
            if (detailsLinkElements != null && detailsLinkElements.hasAttr("href"))
            {
                String url = detailsLinkElements.attr("href");
                advert.setUrl(url);
            }
            if (detailsLinkElements != null && detailsLinkElements.hasText())
            {
                advert.setTitle(detailsLinkElements.text());
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
