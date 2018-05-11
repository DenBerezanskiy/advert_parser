package ua.dp.advertParser.bot;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.api.objects.Contact;
import ua.dp.advertParser.dao.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Denis Berezanskiy on 10.05.2018.
 */
@Service
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
