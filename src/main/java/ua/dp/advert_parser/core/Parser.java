package ua.dp.advert_parser.core;

import org.ccil.cowan.tagsoup.jaxp.SAXParserImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.dp.advert_parser.dao.entity.Advert;
import ua.dp.advert_parser.dao.entity.Search;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Denis Berezanskiy on 12.03.2018.
 */
public class Parser {
        private Advert advert;

        /**
         * Method below is parsing html page with list of adverts .
         * @param url - prepared url with selected parameters of search
         * @return List of adverts links
         */
        public Set parsePage(String url)
        {
            Set<String> links = new HashSet<String>();
            try
            {

                SAXParserImpl.newInstance(null).parse(
                        new URL(url).openConnection().getInputStream(),
                        new DefaultHandler()
                        {
                            public void startElement(String uri, String localName,
                                                     String name, Attributes a)
                            {
                                if (name.equalsIgnoreCase("a") && a != null && a.getValue("class") != null &&
                                        a.getValue("class").contains("detailsLink"))
                                    links.add(a.getValue("href").split("#")[0]);
                            }
                        }
                );

            }
            catch (SAXException | IOException e)
            {
                e.printStackTrace();
            }
            return links;
        }

        /**
         *  Following method is obtain advert parameters like title , price ,description and link
         * @param link - reference of Advert
         * @param search - one of the links returned by the oarsePage() method
         * @return an advert with inserted parameters in it
         */
        public Advert parseAdvert(Search search , String link) {
            advert = new Advert();
            advert.setUrl(link);
            advert.setSearch(search);

            Document document = null;
            try {
                document = Jsoup.connect(link).get();

                //Getting title
                Elements elements = document.getElementsByAttributeValue("class" , "offer-titlebox");
                advert.setTitle(elements.get(0).child(0).text());
                //Getting price
                elements = document.getElementsByAttributeValue("class", "price-label");
                advert.setPrice(elements.get(0).child(0).text());
                //Getting description
                elements = document.getElementsByAttributeValue("id" , "textContent");
                advert.setDescription(elements.get(0).child(0).text());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            if(advert == null)
            {
                System.out.println("something goes wrong!!!");
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
