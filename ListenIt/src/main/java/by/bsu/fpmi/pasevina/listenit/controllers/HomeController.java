package by.bsu.fpmi.pasevina.listenit.controllers;

import by.bsu.fpmi.pasevina.listenit.models.Audio;
import by.bsu.fpmi.pasevina.listenit.models.User;
import by.bsu.fpmi.pasevina.listenit.services.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Home page controller
 * @author Polina Pasevina
 * @version 1.0
 */
@Controller
public class HomeController {

    @Autowired
    private AudioService audioService;

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        return new ModelAndView("../../index");
    }

    @RequestMapping(value = "/about")
    public ModelAndView about() {
        return new ModelAndView("../../WEB-INF/pages/about");
    }
}
