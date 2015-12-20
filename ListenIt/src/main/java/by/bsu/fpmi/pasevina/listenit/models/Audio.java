package by.bsu.fpmi.pasevina.listenit.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AUDIO",
        uniqueConstraints = @UniqueConstraint(columnNames = {"audio_id", "USERNAME"}))
public class Audio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AUDIO_ID")
    private long id;

    @Column(name = "SINGER", nullable = false)
    private String singer;

    @Column(name = "AUDIO_NAME", nullable = false)
    private String audioName;

    @Column(name = "AUDIO_DESCR")
    private String audioDescription;

    @Lob
    @Column(name = "AUDIO_FILE")
    private byte[] audioFile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERNAME", nullable = false)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getAudioDescription() {
        return audioDescription;
    }

    public void setAudioDescription(String audioDescription) {
        this.audioDescription = audioDescription;
    }

    public byte[] getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(byte[] audioFile) {
        this.audioFile = audioFile;
    }

    public User getUser() {
        return user;
    } // показывай

    public void setUser(User user) {
        this.user = user;
    }
}
