package by.bsu.fpmi.pasevina.listenit.dao.impl;

import by.bsu.fpmi.pasevina.listenit.dao.AudioDao;
import by.bsu.fpmi.pasevina.listenit.models.*;
import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Repository
public class AudioDaoImpl implements AudioDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Audio createAudio(Audio audio) {
        getCurrentSession().save(audio);
        getCurrentSession().flush();
        return audio;
    }

    @Override
    public void updateAudio(Audio audio) {
        getCurrentSession().update(audio);
        getCurrentSession().flush();
    }

    @Override
    public void deleteAudio(long id) {
        Audio audio = (Audio) getCurrentSession().createCriteria(Audio.class).
                add(Restrictions.eq("audio_id", id)).uniqueResult();
        getCurrentSession().delete(audio);
        getCurrentSession().flush();
    }

    @Override
    public Audio getAudioById(long id) {
        Criteria criteria =  getCurrentSession().createCriteria(Audio.class).
                add(Restrictions.eq("audio_id", id));
        return (Audio)criteria.list().get(0);
    }

    @Override
    public List<Audio> getPlaylist() {
        Criteria criteria = getCurrentSession().createCriteria(Audio.class);
        criteria.setFetchMode("user", FetchMode.JOIN);
        return criteria.list();
    }

    @Override
    public List<Audio> userPlaylist(String username) {
        Criteria criteria = getCurrentSession().createCriteria(Audio.class);
        criteria.setFetchMode("user", FetchMode.JOIN);
        criteria.add(Restrictions.eq("user.username", username));
        return criteria.list();
    }

    @Override
    public void addLike(User user, long audioId) {
        getCurrentSession().save(new Like(
                new ComplexLikeKey(user.getUsername(), audioId)));
        getCurrentSession().flush();
    }

    @Override
    public void removeLike(User user, long audioId) {
        Like like = (Like) getCurrentSession()
                .createCriteria(Like.class)
                .add(Restrictions.eq(
                        "audio_id", audioId))
                .add(Restrictions.eq("username", user.getUsername()))
                   //     "audio_like", new ComplexLikeKey(user.getUsername(), audioId)))
                .uniqueResult();
        getCurrentSession().delete(like);
        getCurrentSession().flush();
    }

    @Override
    public boolean isLiked(User user, long audioId) {
        Criteria criteria = getCurrentSession().createCriteria(Like.class);
        criteria.add(Restrictions.eq("username", user.getUsername()))
                .add(Restrictions.eq("audio_id", audioId));
        return criteria.list().size() != 0;
    }

    @Override
    public AudioComment addComment(AudioComment comment) {
        getCurrentSession().save(comment);
        getCurrentSession().flush();
        return comment;
    }

    @Override
    public void updateComment(AudioComment comment) {
        getCurrentSession().update(comment);
        getCurrentSession().flush();
    }

    @Override
    public void removeComment(long id) {
        AudioComment comment = (AudioComment) getCurrentSession()
                .createCriteria(AudioComment.class)
                .add(Restrictions.eq("comment_id", id)).uniqueResult();
        getCurrentSession().delete(comment);
        getCurrentSession().flush();
    }

    @Override
    public List<AudioComment> getCommentsByAudioId(long id) {
        Criteria criteria = getCurrentSession().createCriteria(AudioComment.class);
        criteria.setFetchMode("audio", FetchMode.JOIN);
        criteria.setFetchMode("user", FetchMode.JOIN);
        criteria.add(Restrictions.eq("audio.audio_id", id));
        return criteria.list();
    }

    @Override
    public List<Audio> getTopAudio() {
        String hql = "SELECT audio_id FROM audio " +
                "LEFT OUTER JOIN audio_like ON audio_like.audio_id = audio.audio_id" +
                " GROUP BY audio_id " +
                "ORDER BY COUNT(username) DESC";
        SQLQuery query = getCurrentSession().createSQLQuery(hql);
        query.setMaxResults(5);
        List<Integer> fakeAudioId = query.list();
        List<Long> trueAudioId = new ArrayList<Long>();
        for (Integer a : fakeAudioId) {
            trueAudioId.add((long) a);
        }
        DetachedCriteria criteria = DetachedCriteria.forClass(Audio.class)
                .add(Property.forName("audio_id").in(trueAudioId));
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
