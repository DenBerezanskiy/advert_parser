package ua.dp.advertParser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Denis Berezanskiy on 12.04.2018.
 */
@Controller
public class RegisterController
{
    @RequestMapping("/register")
    public String home(ModelMap map) {
        return "register";
    }
}
