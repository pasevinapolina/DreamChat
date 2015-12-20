package by.bsu.fpmi.pasevina.listenit.controllers;

import by.bsu.fpmi.pasevina.listenit.models.AudioComment;
import by.bsu.fpmi.pasevina.listenit.models.User;
import by.bsu.fpmi.pasevina.listenit.services.AudioService;
import by.bsu.fpmi.pasevina.listenit.utils.Pair;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Controller
public class MusicController {
    @Autowired
    AudioService audioService;

    @RequestMapping(value = "/audio/{audioId}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] getAudio(@PathVariable String audioId) {
        return audioService.getAudioById(Long.parseLong(audioId)).getAudioFile();
    }

    @RequestMapping(value = "/audio/{audioId}/switchLike", method = RequestMethod.GET)
    @ResponseBody
    public String switchLike(@PathVariable String audioId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (audioService.isLiked(user, Integer.parseInt(audioId))) {
            audioService.removeLike(user, Integer.parseInt(audioId));
            return "1";
        }
        audioService.addLike(user, Integer.parseInt(audioId));
        return "0";
    }

    @RequestMapping(value = "/audio/{audioId}/isLike", method = RequestMethod.GET)
    @ResponseBody
    public String isLike(@PathVariable String audioId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (audioService.isLiked(user, Integer.parseInt(audioId))) {
            return "1";
        }
        return "0";
    }


    @RequestMapping(value = "/audio/{audioId}/addComment", method = RequestMethod.POST)
    @ResponseBody
    public void addComment(@RequestParam String commentSrc,
                           @PathVariable String audioId,
                           HttpServletRequest request) {
        AudioComment newComment = new AudioComment();
        newComment.setUser((User) request.getSession().getAttribute("user"));
        newComment.setAudio(audioService.getAudioById(Integer.parseInt(audioId)));
        newComment.setDescription(commentSrc);
        audioService.addComment(newComment);
    }


    @RequestMapping(value = "/audio/{audioId}/getComments", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getComments(@PathVariable String audioId) {
        List<Pair<String, String>> commentSource = new ArrayList<Pair<String, String>>();
        List<AudioComment> comments = audioService.getCommentsByAudioId(Integer.parseInt(audioId));

        for (AudioComment com : comments) {
            commentSource.add(new Pair<String, String>(com.getDescription(),
                    com.getUser().getUsername()));
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(commentSource);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
