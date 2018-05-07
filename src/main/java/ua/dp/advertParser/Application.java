package ua.dp.advertParser;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.logging.BotLogger;
import org.telegram.telegrambots.logging.BotsFileHandler;
import ua.dp.advertParser.bot.Bot;
import ua.dp.advertParser.core.Service;
import ua.dp.advertParser.core.WebService;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

/**
 * Created by Denis Berezanskiy on 27.03.2018.
 */

//TODO: Implement Spring Boot
@EnableScheduling
public class Application
{
    private static final String LOGTAG = "MAIN";
    
    private Service service;
<<<<<<< HEAD
=======
    private WebService WebService;
>>>>>>> mvc_impl
    
    public static void main(String[] args)
    {
        System.out.println("Start");
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Context initialized");
        
        Application application = (Application) context.getBean("application");
        
<<<<<<< HEAD
        application.service.findAdverts();
        application.service.sendAdverts();
        
        //TODO : Next step is implementing of Spring MVC principles
        //TODO : and front-end part
=======
        application.botInitialize();
        
        application.service.findAdverts();
        application.service.sendAdverts();
        
>>>>>>> mvc_impl
        //TODO : Implement Logger
    }
    
    public void setService(Service service)
    {
        this.service = service;
    }
    
    public Service getService()
    {
        return service;
    }
    
    public void setWebService(WebService WebService) {this.WebService = WebService;}
    
    public WebService getWebService() { return WebService; }
    
    private void botInitialize()
    {
        BotLogger.setLevel(Level.ALL);
        BotLogger.registerLogger(new ConsoleHandler());
        try
        {
            BotLogger.registerLogger(new BotsFileHandler());
        }
        catch (IOException e)
        {
            BotLogger.severe(LOGTAG, e);
        }
        ApiContextInitializer.init();
        
        TelegramBotsApi api = new TelegramBotsApi();
        try
        {
            api.registerBot(new Bot());
            
        }
        catch (TelegramApiRequestException e)
        {
            e.printStackTrace();
        }
        System.out.println("\n BOT SUCCESSFULLY STARTED \n");
    }
    
    
}
