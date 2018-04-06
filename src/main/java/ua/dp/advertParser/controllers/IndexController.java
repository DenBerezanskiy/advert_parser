package ua.dp.advertParser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Denis Berezanskiy on 06.04.2018.
 */
@Controller
public class IndexController
{
    @RequestMapping("/")
    public String home(ModelMap map) {
        return "index";
    }
}
