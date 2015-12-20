package by.bsu.fpmi.pasevina.listenit.dao;

import by.bsu.fpmi.pasevina.listenit.models.Audio;
import by.bsu.fpmi.pasevina.listenit.models.AudioComment;
import by.bsu.fpmi.pasevina.listenit.models.User;

import java.util.List;

/**
 *
 */
public interface AudioDao {

    Audio createAudio(Audio audio);
    void updateAudio(Audio audio);
    void deleteAudio(long id);
    Audio getAudioById(long id);
    
    List<Audio> getPlaylist();
    List<Audio> userPlaylist(String username);

    void addLike(User user, long audioId);
    void removeLike(User user, long audioId);
    boolean isLiked(User user, long audioId);

    AudioComment addComment(AudioComment comment);
    void updateComment(AudioComment comment);
    void removeComment(long id);

    List<AudioComment> getCommentsByAudioId(long id);
    List<Audio> getTopAudio();
}
