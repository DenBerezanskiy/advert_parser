package ua.dp.advertParser;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import ua.dp.advertParser.core.Service;
import ua.dp.advertParser.core.WebService;

/**
 * Created by Denis Berezanskiy on 27.03.2018.
 */

//TODO: Implement Spring Boot
@EnableScheduling
public class Application
{
    private static final String LOGTAG = "MAIN";
    
    private Service service;
    private WebService WebService;
    
    public static void main(String[] args)
    {
        System.out.println("Start");
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Context initialized");
        
        Application application = (Application) context.getBean("application");
        
        //        application.botInitialize();
        
        application.service.findAdverts();
        application.service.sendAdverts();
        
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
    
    
}
