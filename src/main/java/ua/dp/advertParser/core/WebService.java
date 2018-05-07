package ua.dp.advertParser.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.advertParser.dao.entity.Search;
import ua.dp.advertParser.dao.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Denis Berezanskiy on 26.04.2018.
 */
//TODO: Logger
//TODO: Refactor with Spring Framework

public class WebService
{
    private User user;
    @PersistenceContext
    private EntityManager entityManager;
    
    public boolean validateUser(String username, String password)
    {
        boolean isValid = false;
        
        Query query = entityManager.createQuery("from User where username = :user and password = :pass");
        query.setParameter("user", username);
        query.setParameter("pass", password);
        List result = query.getResultList();
        if (!result.isEmpty())
        {
            isValid = true;
        }
        return isValid;
    }
    
    @Transactional
    public void createUser(String username, String password, String email, String phone)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        entityManager.persist(user);
    }
    
    public boolean isUserExists(String username)
    {
        boolean isExists = false;
        Query query = entityManager.createQuery("from User where username = :user");
        query.setParameter("user", username);
        List result = query.getResultList();
        if (!result.isEmpty())
        {
            isExists = true;
        }
        return isExists;
    }
    
    @Transactional
    public void delegateLink(String link)
    {
        Search search = new Search(link);
        if (isSearchLinkExists(link))
        {
            Query activateExistingSearch = entityManager.createQuery("update Search" + " set isActive = 0 where searchLink = :link");
            activateExistingSearch.setParameter("link", link);
            activateExistingSearch.executeUpdate();
            
        }
        else
        {
            entityManager.persist(search);
        }
        Query deactivateOtherSearches = entityManager.
                createQuery("update Search set isActive = 1 where searchLink != '" + link + "'");
        deactivateOtherSearches.executeUpdate();
        
        
    }
    
    private boolean isSearchLinkExists(String link)
    {
        boolean isLinkExists = false;
        Query query = entityManager.createQuery("from Search where searchLink = : link");
        query.setParameter("link", link);
        
        List result = query.getResultList();
        if (result.isEmpty())
        {
            isLinkExists = true;
        }
        return isLinkExists;
    }
    
    public void setUser(User user)
    {
        this.user = user;
    }
}
