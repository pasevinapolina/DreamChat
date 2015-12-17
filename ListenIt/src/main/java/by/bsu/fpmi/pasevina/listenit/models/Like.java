package by.bsu.fpmi.pasevina.listenit.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Entity
@Table(name = "audio_like", uniqueConstraints = @UniqueConstraint(
        columnNames = {"audio_id", "username"}))
public class Like implements Serializable {

        private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ComplexLikeKey likeId;

    @Column(name = "like_num", nullable = false)
    private int likeAmount;

    public Like() {
    }

    public ComplexLikeKey getLikeId() {
        return likeId;
    }

    public void setLikeId(ComplexLikeKey likeId) {
        this.likeId = likeId;
    }

    public Like(ComplexLikeKey likeId) {
        this.likeId = likeId;
    }

    public int getLikeAmount() {
        return likeAmount;
    }

    public void setLikeAmount(int likeAmount) {
        this.likeAmount = likeAmount;
    }
}
