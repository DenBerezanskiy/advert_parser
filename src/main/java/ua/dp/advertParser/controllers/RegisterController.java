package ua.dp.advertParser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Denis Berezanskiy on 12.04.2018.
 */
@Controller
public class RegisterController
{
    
    @RequestMapping("/register")
    public ModelAndView welcome()
    {
        String message = "";
        return new ModelAndView("register", "message", message);
    }
}
