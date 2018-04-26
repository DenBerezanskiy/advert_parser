package ua.dp.advertParser.dao.entity;

import javax.persistence.*;

/**
 * Created by Denis Berezanskiy on 12.03.2018.
 */
@Entity
@Table(name = "adverts")
public class Advert
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String url;
    private String title;
    //price is String variable because it displaying like a String value in html page.
    private String price;
    @Embedded
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "search_id")
    private Search search;
    @Column(columnDefinition = "int default 0")
    private int sent;
    @Embedded
    @OneToOne
    @JoinColumn(name = "username")
    private User user;
    public Advert() {
    }

    public Advert(String url, String title, String price, Search search,User user) {
        this.url = url;
        this.title = title;
        this.price = price;
        this.search = search;
        this.user = user;
    }
    
    public User getUser()
    {
        return user;
    }
    
    public void setUser(User user)
    {
        this.user = user;
    }
    
    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getSent() {
        return sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }

    @Override
    public String toString() {
        return "Advert{" +
                " url='" + url + '\'' + "\n" +
                ", title='" + title + '\'' + "\n" +
                ", price='" + price + '\'' + "\n" +
                ", search=" + search + "\n" +
                '}';
    }
}
