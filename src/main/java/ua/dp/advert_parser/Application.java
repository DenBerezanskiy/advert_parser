package ua.dp.advert_parser;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import ua.dp.advert_parser.core.Service;

/**
 * Created by Denis Berezanskiy on 27.03.2018.
 */

@EnableScheduling
public class Application {

    private Service service;

    public static void main(String[] args) {
        System.out.println("Start");
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Context initialised");
        Application application =
                (Application) context.getBean("application");

                application.service.findAdverts();
                application.service.sendAdverts();
    }


    public void setService(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }
}
