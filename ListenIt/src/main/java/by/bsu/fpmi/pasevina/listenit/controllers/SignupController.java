package by.bsu.fpmi.pasevina.listenit.controllers;

import by.bsu.fpmi.pasevina.listenit.models.Audio;
import by.bsu.fpmi.pasevina.listenit.models.User;
import by.bsu.fpmi.pasevina.listenit.services.AudioService;
import by.bsu.fpmi.pasevina.listenit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */


@Controller
public class SignupController {

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @Autowired
    private UserService userService;

    @Autowired
    private AudioService audioService;

    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public ModelAndView getSignup() {
        ModelAndView modelAndView = new ModelAndView("../../WEB-INF/pages/signup");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("user") @Valid User newUser,
                                     BindingResult result, Errors errors, HttpServletRequest request) {
        User registered = new User();

        if(!passwordMatches(newUser)) {
            result.rejectValue("password", "message.regError", "Passwords don't matches");
        }

        if(!result.hasErrors()) {
            registered = createUserAccount(newUser, result);
        }
        if(registered == null) {
            result.rejectValue("username", "message.regError", "Wrong username or password");
        }

        if(result.hasErrors()) {
            return  new ModelAndView("../../WEB-INF/pages/signup", "user", newUser);
        }
        else {
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(registered.getUsername(), newUser.getPassword());
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = authManager.authenticate(token);

            request.getSession()
                    .setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                            SecurityContextHolder.getContext());
            //request.getSession().setAttribute("username", registered.getUsername());
            request.getSession().setAttribute("user", registered);
        }

//        ModelAndView modelAndView = new ModelAndView("../../index");

        ModelAndView modelAndView = new ModelAndView("../../WEB-INF/pages/gallery");

        List<Audio> playlist = audioService.getPlaylist();
        List<String> audios = new ArrayList<String>();
        List<Boolean> likedAudio = new ArrayList<Boolean>();


        for (Audio audio : playlist) {
            audios.add("/audio/" + audio.getAudio_id());
            likedAudio.add(audioService.isLiked(registered, audio.getAudio_id()));
        }

        modelAndView.addObject("playlist", playlist);
        modelAndView.addObject("audios", audios);
        modelAndView.addObject("likes", likedAudio);

        return modelAndView;
    }

    private User createUserAccount(User newUser, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewAccount(newUser);
        } catch (NullPointerException e) {
            return null;
        }
        return registered;
    }

    private boolean passwordMatches(User user) {
        if(user == null) {
            return false;
        }
        if(user.getPassword() == null || user.getMatchingPassword() == null) {
            return false;
        }
        return user.getPassword().equals(user.getMatchingPassword());
    }

}
