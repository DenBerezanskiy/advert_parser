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
 * Created by Denis Berezanskiy on 12.04.2018.
 */
//TODO: Implement registration with Spring Security
//TODO: Possibility to stay signed in after registration
//TODO: Logger

@Controller
public class RegisterController
{
    private WebService webService;
    
    @RequestMapping("/register")
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("register");
        return mav;
    }
    
    @RequestMapping("/registerUser")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        ModelAndView mav = new ModelAndView("register");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        RegisterController registerController = (RegisterController) context.getBean("registerController");
        
        if (registerController.webService.isUserExists(username))
        {
            mav.addObject("existsMessage", "User already exists!");
        }
        else
        {
            int usernameLength = username.toCharArray().length;
            int passLength = password.toCharArray().length;
            int phoneLength = phone.toCharArray().length;
            boolean canBeRegistred = true;
            if (username.isEmpty() || usernameLength < 3 || usernameLength > 16)
            {
                String message = "username must contain 3-16 characters";
                mav.addObject("userMessage", message);
                canBeRegistred = false;
            }
            if (password.isEmpty() || (password.length() < 3 && password.length() > 16))
            {
                String message = "password  must contain 3-16 characters";
                mav.addObject("passMessage", message);
                canBeRegistred = false;
            }
            if (email.isEmpty() || (!email.contains("@") && !email.contains(".")))
            {
                String message = "email  must be like admin@root.com";
                mav.addObject("emailMessage", message);
                canBeRegistred = false;
            }
            if (phone.isEmpty() || phoneLength < 13 || !phone.contains("+"))
            {
                String message = "phone  must be like  +380112233344";
                mav.addObject("passMessage", message);
                canBeRegistred = false;
            }
            if (canBeRegistred)
            {
                registerController.webService.createUser(username, password, email, phone);
                mav.setViewName("searchPage");
                mav.addObject("message", "Your account has been created successfully");
            }
            
        }
        
        return mav;
    }
    
    public void setWebService(WebService WebService)
    {
        this.webService = WebService;
    }
    
    public WebService getWebService()
    {
        return webService;
    }
}
