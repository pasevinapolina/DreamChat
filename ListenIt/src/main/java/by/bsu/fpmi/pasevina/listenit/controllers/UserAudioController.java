package by.bsu.fpmi.pasevina.listenit.controllers;

import by.bsu.fpmi.pasevina.listenit.models.Audio;
import by.bsu.fpmi.pasevina.listenit.models.User;
import by.bsu.fpmi.pasevina.listenit.services.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Controller
public class UserAudioController {
    @Autowired
    private AudioService audioService;

    @RequestMapping(value = "/myAudios", method = RequestMethod.GET)
    public ModelAndView getMyAudios(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        ModelAndView modelAndView = new ModelAndView("../../WEB-INF/pages/myAudio");

        List<Audio> userPlaylist = audioService.getUserPlaylist(user.getUsername());
        List<String> allAudios = new ArrayList<String>();
        for (Audio audio : userPlaylist) {
            allAudios.add("/audio/" + audio.getId());
        }
        modelAndView.addObject("user", user);

        modelAndView.addObject("playlists", userPlaylist);
        modelAndView.addObject("audios", allAudios);
        return modelAndView;
    }

    @RequestMapping(value = "/myAudios", method = RequestMethod.POST)
    public String addNewAudioFile(@ModelAttribute("audioFile") Audio newPlaylist,
                                  @RequestParam MultipartFile audioFile,
                              HttpServletRequest request) {

        User currentUser = (User)request.getSession().getAttribute("user");
        Audio audio = getNewPlaylist(newPlaylist, currentUser, audioFile);
        audioService.createNewAudio(audio);

        return "redirect:/myAudios";
    }

    @RequestMapping(value = "/myAudios/{audioId}/delete", method = RequestMethod.GET)
    public String deleteAudio(@PathVariable String audioId) {
        audioService.deleteAudioById(Long.parseLong(audioId));
        return "redirect:/myAudios";
    }

    @RequestMapping(value = "/myAudios/{idPlace}/update", method = RequestMethod.POST)
    public String updateAudio(@ModelAttribute("audio") Audio newPlaylist,
                              @RequestParam MultipartFile audioFile,
                              @PathVariable String idPlaylist) {
        Audio updatingPlaylist = audioService.getAudioById(Integer.parseInt(idPlaylist));
        try {
            if (audioFile.getBytes().length != 0) {
                updatingPlaylist.setAudioFile(audioFile.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        updatingPlaylist.setAudioDescription(newPlaylist.getAudioDescription());
        updatingPlaylist.setAudioName(newPlaylist.getAudioName());
        audioService.updateAudio(updatingPlaylist);
        return "redirect:/myAudios";
    }

    private Audio getNewPlaylist(Audio newPlaylist, User user, MultipartFile audioFile) {
        Audio audio = new Audio();
        audio.setAudioName(newPlaylist.getAudioName());
        audio.setAudioDescription(newPlaylist.getAudioDescription());
        audio.setUser(user);
        if (!audioFile.isEmpty()) {
            try {
                byte[] bytes = audioFile.getBytes();
                audio.setAudioFile(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return audio;
    }
}
