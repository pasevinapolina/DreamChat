package by.bsu.fpmi.pasevina.listenit.services.impl;

import by.bsu.fpmi.pasevina.listenit.dao.AudioDao;
import by.bsu.fpmi.pasevina.listenit.models.Audio;
import by.bsu.fpmi.pasevina.listenit.models.AudioComment;
import by.bsu.fpmi.pasevina.listenit.models.User;
import by.bsu.fpmi.pasevina.listenit.services.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service("audioService")
@Transactional
public class AudioServiceImpl implements AudioService {

    @Autowired
    private AudioDao audioDao;

    @Override
    public Audio createNewAudio(Audio audio) {
        return audioDao.createAudio(audio);
    }

    @Override
    public Audio getAudioById(long id) {
        return audioDao.getAudioById(id);
    }

    @Override
    public void updateAudio(Audio audio) {
        audioDao.updateAudio(audio);
    }

    @Override
    public void deleteAudioById(long id) {
        audioDao.deleteAudio(id);
    }

    @Override
    public List<Audio> getPlaylist() {
        return audioDao.getPlaylist();
    }

    @Override
    public List<Audio> getUserPlaylist(String username) {
        return audioDao.userPlaylist(username);
    }

    @Override
    public boolean isLiked(User user, long audioId) {
        return audioDao.isLiked(user, audioId);
    }

    @Override
    public void addLike(User user, long audioId) {
        audioDao.addLike(user, audioId);
    }

    @Override
    public void removeLike(User user, long audioId) {
        audioDao.removeLike(user, audioId);
    }

    @Override
    public AudioComment addComment(AudioComment comment) {
        return audioDao.addComment(comment);
    }

    @Override
    public void removeComment(long id) {
        audioDao.removeComment(id);
    }

    @Override
    public void updateComment(AudioComment comment) {
        audioDao.updateComment(comment);
    }

    @Override
    public List<AudioComment> getCommentsByAudioId(long id) {
        return audioDao.getCommentsByAudioId(id);
    }

    @Override
    public List<Audio> getTopAudio() {
        return audioDao.getTopAudio();
    }
}
