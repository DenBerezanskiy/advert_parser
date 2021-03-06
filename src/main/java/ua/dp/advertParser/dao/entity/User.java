package ua.dp.advertParser.dao.entity;

import javax.persistence.*;

/**
 * Created by Denis Berezanskiy on 12.04.2018.
 */
//TODO: equals method
@Embeddable
@Entity
@Table(name = "users")
public class User
{
    @Id
    @Column(unique = true, nullable = false, name = "username")
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String phone;
    private long chatId;
    
    public User()
    {
    }
    
    public User(String username, String password, String email, String phone)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public long getChatId()
    {
        return chatId;
    }
    
    public void setChatId(long chatId)
    {
        this.chatId = chatId;
    }
}
