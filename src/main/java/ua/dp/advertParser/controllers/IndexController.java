package ua.dp.advertParser.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.dp.advertParser.core.WebService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Denis Berezanskiy on 06.04.2018.
 */

//TODO: Implement login with Spring Security
//TODO: Implement an account system. For example possibility to log in/log out
//TODO:Logger
//TODO: Try to find the way how to avoid initializing context.

@Controller
public class IndexController
{
    private WebService WebService;
    
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    
    @RequestMapping("/validateLogin")
    public ModelAndView validateLogin(HttpServletResponse response, HttpServletRequest request)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        IndexController indexController = (IndexController) context.getBean("indexController");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ModelAndView mav = new ModelAndView("index");
        if (!indexController.WebService.validateUser(username, password))
        {
            if (username.isEmpty())
            {
                String message = "Username cannot be empty";
                mav.addObject("loginMessage", message);
            }
            if (password.isEmpty())
            {
                String message = "Password cannot be empty";
                mav.addObject("passMessage", message);
            }
            String message = "Invalid credentials";
            mav.addObject("errorMessage", message);
            System.out.println(username);
            System.out.println(password);
        }
        else
        {
            try
            {
                response.sendRedirect("/searchPage");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return mav;
    }
    
    public void setWebService(WebService WebService)
    {
        this.WebService = WebService;
    }
}
