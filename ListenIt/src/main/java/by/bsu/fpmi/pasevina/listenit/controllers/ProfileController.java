package by.bsu.fpmi.pasevina.listenit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */

@Controller
public class ProfileController {

    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public ModelAndView editProfile() {
        return new ModelAndView("../../WEB-INF/pages/profile");
    }
}
