package ua.dp.advertParser.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.advertParser.dao.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Denis Berezanskiy on 26.04.2018.
 */
public class UserService
{
    private User user;
    @PersistenceContext
 private EntityManager entityManager;
    
    public boolean validate(String username, String password)
    {
        boolean isValid = false;
        
        Query query = entityManager.createQuery("from User where username = :user and password = :pass");
        query.setParameter("user",username);
        query.setParameter("pass",password);
        List result = query.getResultList();
        if(!result.isEmpty())
        {
            isValid = true;
        }
        return isValid;
    }
    @Transactional
    public void  createUser(String username,String password , String email , String phone)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        entityManager.persist(user);
    }
    public  boolean isUserExists(String username)
    {
        boolean isExists = false;
        Query query = entityManager.createQuery("from User where username = :user");
        query.setParameter("user",username);
        List result = query.getResultList();
        if(!result.isEmpty())
        {
            isExists = true;
        }
        return isExists;
    }
    
    public void setUser(User user)
    {
        this.user = user;
    }
}
