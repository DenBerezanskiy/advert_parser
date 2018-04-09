package ua.dp.advertParser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.dp.advertParser.dao.entity.Advert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Controller
public class WelcomeController
{
    EntityManager entityManager;
    @RequestMapping("/welcome")
    public ModelAndView welcome()
    {
        String message = "";
        return new ModelAndView("welcome", "message", message);
    }
}
