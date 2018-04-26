package ua.dp.advertParser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.dp.advertParser.core.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Denis Berezanskiy on 06.04.2018.
 */
@Controller
public class IndexController
{
    private UserService userService;
    
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response)
 {
     ModelAndView mav =  new ModelAndView("index");
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
        if(!indexController.userService.validate(username,password))
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
    
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }
}
