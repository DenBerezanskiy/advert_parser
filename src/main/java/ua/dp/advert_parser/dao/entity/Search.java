package ua.dp.advert_parser.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by Denis Berezanskiy on 12.03.2018.
 */
@Embeddable
@Entity
@Table(name = "serch_history")
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String searchLink;
    private Timestamp timestamp;

    public Search(String searchLink)
    {
        this.searchLink = searchLink;
        this.timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getSearchLink()
    {
        return searchLink;
    }

    public void setSearchLink(String searchLink)
    {
        this.searchLink = searchLink;
    }

    @Override
    public String toString()
    {
        return "Search{" +
                "searchLink='" + searchLink + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
