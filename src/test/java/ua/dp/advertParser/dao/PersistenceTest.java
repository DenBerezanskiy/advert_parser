package ua.dp.advertParser.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Denis Berezanskiy on 27.03.2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistentApplicationContext.xml")
@Transactional
public class PersistenceTest
{
    @PersistenceContext
    EntityManager em;
    
    @Autowired
    LocalContainerEntityManagerFactoryBean context;
    
    @Test
    public void testPersistence() throws Exception
    {
        context.toString();
        List result = em.createQuery("select a from Advert a").getResultList();
        System.out.println(result);
        result = em.createQuery("select s from Search s").getResultList();
    }
}
