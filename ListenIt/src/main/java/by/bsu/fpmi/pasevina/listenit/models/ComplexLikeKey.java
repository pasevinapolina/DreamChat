package by.bsu.fpmi.pasevina.listenit.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 */
@Embeddable
public class ComplexLikeKey implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "audio_id", nullable = false)
    private long audioId;

    public ComplexLikeKey(){}

    public ComplexLikeKey(String username, long audioId) {
        this.username = username;
        this.audioId = audioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplexLikeKey that = (ComplexLikeKey) o;

        if (audioId != that.audioId) return false;
        return !(username != null ? !username.equals(that.username) : that.username != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (int) (audioId ^ (audioId >>> 32));
        return result;
    }
}
