package by.bsu.fpmi.pasevina.listenit.services;

import by.bsu.fpmi.pasevina.listenit.models.Audio;
import by.bsu.fpmi.pasevina.listenit.models.AudioComment;
import by.bsu.fpmi.pasevina.listenit.models.User;

import java.util.List;

/**
 *
 */
public interface AudioService {

    Audio createNewAudio(Audio audio);
    Audio getAudioById(long id);
    void updateAudio(Audio audio);
    void deleteAudioById(long id);

    List<Audio> getPlaylist();
    List<Audio> getUserPlaylist(String username);

    boolean isLiked(User user, long audioId);

    void addLike(User user, long audioId);
    void removeLike(User user, long audioId);

    AudioComment addComment(AudioComment comment);
    void removeComment(long id);
    void updateComment(AudioComment comment);

    List<AudioComment> getCommentsByAudioId(long id);

    List<Audio> getTopAudio();
}
