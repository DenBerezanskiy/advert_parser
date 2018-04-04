package ua.dp.advertParser;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import ua.dp.advertParser.core.Service;

/**
 * Created by Denis Berezanskiy on 27.03.2018.
 */
@EnableScheduling
public class Application
{
    private Service service;

    public static void main(String[] args)
    {
        System.out.println("Start");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("Context initialized");

        Application application = (Application) context.getBean("application");

        application.service.findAdverts();
        application.service.sendAdverts();

        //TODO : Next step is implementing of Spring MVC principles
        //TODO : and front-end part
        //TODO : Implement Logger
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }
}