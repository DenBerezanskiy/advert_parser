package ua.dp.advert_parser.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import ua.dp.advert_parser.dao.entity.Advert;
import ua.dp.advert_parser.dao.entity.Search;

/**
 * Created by Denis Berezanskiy on 27.03.2018.
 */
public class Parser {
    private Advert advert;

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

    public Advert parseAdvert(Element element, Search search) {
        advert = new Advert();
        advert.setSearch(search);

        if (element != null)
        {
            // To do: Please check what you really need to get all elements with "detailsLink, price and _a_"
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
