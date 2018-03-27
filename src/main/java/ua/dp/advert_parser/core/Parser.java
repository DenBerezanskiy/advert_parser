package ua.dp.advert_parser.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.dp.advert_parser.dao.entity.Advert;
import ua.dp.advert_parser.dao.entity.Search;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Denis Berezanskiy on 27.03.2018.
 */
public class Parser {
    private Advert advert;

    public Elements parsePage(String url) {
        Document doc = null;
        Elements elements = null;
        try {
            doc = Jsoup.connect(url).get();
            elements = doc.getElementsByAttributeValue("class", "offer");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return elements;
    }

    public Advert parseAdvert(Element element, Search search) {
        advert = new Advert();
        advert.setSearch(search);
        if (element != null) {
            if (element.getElementsByAttributeValueContaining("class", "detailsLink") != null
                    && element.getElementsByAttributeValueContaining("class", "detailsLink").hasAttr("href")) {
                String url = element.getElementsByAttributeValueContaining("class", "detailsLink").attr("href");
                advert.setUrl(url);
            }
            if (element.getElementsByTag("a") != null && element.getElementsByTag("a").text() != null) {
                String title = element.getElementsByTag("a").text();
                advert.setTitle(title);
            }
            if (element.getElementsByAttributeValue("class", "price") != null &&
                    element.getElementsByAttributeValue("class", "price").text() != null) {
                String price = element.getElementsByAttributeValue("class", "price").text();
                advert.setPrice(price);
            }
        }
            return advert;
    }

    public void setAdvert(Advert Advert) {
        advert = Advert;
    }

    public Advert getAdvert() {
        return advert;
    }
}
