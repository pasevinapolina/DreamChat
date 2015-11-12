package by.bsu.fpmi.pasevina.listenit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Home page controller
 * @author Polina Pasevina
 * @version 1.0
 */
@Controller
public class HomeController {
    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public ModelAndView dashboard(/*HttpServletRequest, HttpServletResponse*/) {
        return new ModelAndView("../../index");
    }
}
