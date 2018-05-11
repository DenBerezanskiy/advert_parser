package ua.dp.advertParser.bot;

import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.api.objects.Contact;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Denis Berezanskiy on 10.05.2018.
 */
public class BotService
{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public void attachChatIdToUser(Contact contact, long chatId)
    {
        Query query = entityManager.createQuery("update User set chatId = :id where phone = :phoneNumber");
        query.setParameter("id", chatId);
        query.setParameter("phoneNumber", contact.getPhoneNumber());
        query.executeUpdate();
        query.executeUpdate();
    }
    
}
