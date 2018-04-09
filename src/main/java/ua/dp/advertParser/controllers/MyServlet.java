package ua.dp.advertParser.controllers;

import ua.dp.advertParser.core.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by Denis Berezanskiy on 09.04.2018.
 */
public class MyServlet extends HttpServlet
{
    private String searchLink  = null;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        searchLink = req.getParameter("fname");
        System.out.println(searchLink);
        System.out.println(searchLink);
        System.out.println(searchLink);
        System.out.println("get");
        resp.sendRedirect("/welcome");
        System.out.println("search link is :" +searchLink);
        
    }
}

