package by.bsu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HttpServletBean;

/**
 * Home page controller
 * @author Polina Pasevina
 * @version 1.0
 */
@Controller
public class HomeController {
    @RequestMapping(value="welcome")
    public  String dashboard(/*HttpServletRequest, HttpServletResponse*/) {
        return "dashboard";
    }
}
