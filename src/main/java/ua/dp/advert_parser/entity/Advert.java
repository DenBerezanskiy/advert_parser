package ua.dp.advert_parser.entity;

import javax.persistence.*;
import java.io.Serializable;

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
    private String description;
    public Advert() {
    }

    public Advert(String url, String title, String price, String description) {
        this.url = url;
        this.title = title;
        this.price = price;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Advert{" +
                "url='" + url + '\'' +
                ",\n title='" + title + '\'' +
                ",\n price='" + price + '\'' +
                ",\n description='" + description + '\'' +
                '}';
    }
}
