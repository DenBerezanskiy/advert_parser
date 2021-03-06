package ua.dp.advertParser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis Berezanskiy on 06.04.2018.
 */
//TODO:Logger
@Controller
public class ErrorController
{
    @RequestMapping(path = "/error")
    public Map<String, Object> handle(HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", request.getAttribute("javax.servlet.error.status_code"));
        map.put("reason", request.getAttribute("javax.servlet.error.message"));
        return map;
    }
}
