package ua.dp.advert_parser.core;

import ua.dp.advert_parser.dao.entity.Advert;
import ua.dp.advert_parser.dao.entity.Search;

import java.util.Set;

/**
 * Created by Denis Berezanskiy on 13.03.2018.
 */
public class App
{
    public static void main(String[] args) {
        Parser parser = new Parser();

        Advert advert = parser.parseAdvert(new Search(), "https://www.olx.pl/oferta/peugeot-405-pierwszy-wlasciciel-piekny-cena-do-negocjacji-CID5-IDqfGxN.html#6256e9ac30");

    }
}
