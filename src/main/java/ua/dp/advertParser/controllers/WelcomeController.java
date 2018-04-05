package ua.dp.advertParser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController
{

    @RequestMapping("/welcome")
    public ModelAndView welcome(){
        String message = "<br><div style='text-align:center;'>"
                + "<h3>********** Hello , its Advert Parser</h3>This message is coming from WelcomeController.java **********</div><br><br>";
        return new ModelAndView("welcome", "message", message);
    }
}
