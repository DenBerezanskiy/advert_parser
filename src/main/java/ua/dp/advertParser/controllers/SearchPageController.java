package ua.dp.advertParser.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.dp.advertParser.core.WebService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Denis Berezanskiy on 12.04.2018.
 */
//TODO: Implement redirecting to page with user's search history
//TODO: Logger
@Controller
public class SearchPageController
{
    private WebService webService;
    
    @RequestMapping("/searchPage")
    public String home(ModelMap map)
    {
        return "searchPage";
    }
    
    @RequestMapping("/delegateLink")
    public ModelAndView delegate(HttpServletRequest request, HttpServletResponse response)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SearchPageController searchController = (SearchPageController) context.getBean("searchPageController");
        
        ModelAndView mav = new ModelAndView("searchPage");
        String link = request.getParameter("inputField");
        searchController.webService.delegateLink(link);
        
        return mav;
    }
    
    public WebService getWebService()
    {
        return webService;
    }
    
    public void setWebService(WebService webService)
    {
        this.webService = webService;
    }
}
