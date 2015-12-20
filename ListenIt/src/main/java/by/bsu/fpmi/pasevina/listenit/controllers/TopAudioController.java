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
 *
 */
@Controller
public class TopAudioController {

    @Autowired
    private AudioService audioService;

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public ModelAndView getTop(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        ModelAndView modelAndView = new ModelAndView("../../WEB-INF/pages/top");
        List<Audio> topPlaylists = audioService.getTopAudio();
        List<String> audios = new ArrayList<String>();
        List<Boolean> likedAudios = new ArrayList<Boolean>();


        for (Audio audio : topPlaylists) {
            audios.add("/audio/" + audio.getAudio_id());
            likedAudios.add(audioService.isLiked(user, audio.getAudio_id()));
        }

        modelAndView.addObject("playlists", topPlaylists);
        modelAndView.addObject("audios", audios);
        modelAndView.addObject("likes", likedAudios);

        return modelAndView;
    }
}
