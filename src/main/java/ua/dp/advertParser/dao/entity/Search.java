package ua.dp.advertParser.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by Denis Berezanskiy on 12.03.2018.
 */
@Embeddable
@Entity
@Table(name = "serch_history")
public class Search
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String searchLink;
    private Timestamp timestamp;
    @Column(columnDefinition = "int default 0")
    private int isActive;
    
    public Search(String searchLink)
    {
        this.searchLink = searchLink;
        this.timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
    }
    
    public Search()
    {
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
    
    public int getIsActive()
    {
        return isActive;
    }
    
    public void setIsActive(int isActive)
    {
        this.isActive = isActive;
    }
    
    @Override
    public String toString()
    {
        return "Search{" + "searchLink='" + searchLink + '\'' + ", timestamp=" + timestamp + '}';
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        
        Search search = (Search) o;
        
        if (id != search.id)
            return false;
        if (!searchLink.equals(search.searchLink))
            return false;
        return (!timestamp.equals(search.timestamp));
        
    }
    
}
