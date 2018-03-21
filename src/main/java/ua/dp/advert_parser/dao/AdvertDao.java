package ua.dp.advert_parser.dao;

import ua.dp.advert_parser.dao.entity.Advert;

import java.util.List;

/**
 * Created by Denis Berezanskiy on 21.03.2018.
 */
public interface AdvertDao
{
    void save(Advert advert);
    List<Advert> getAllNotSent();
}
