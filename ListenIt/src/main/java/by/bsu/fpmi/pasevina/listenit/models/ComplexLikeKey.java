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
}
