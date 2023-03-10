package gyber.org.mainCore.data.entities;

import gyber.org.mainCore.data.entities.enums.TypeMediaFile;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "users_media_files")
public class MediaFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mediaHash;

    @Enumerated(EnumType.STRING)
    private TypeMediaFile mediaType;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private UserAllData userAllData;



    public MediaFile(String hashPhoto , TypeMediaFile typeMedia) {
        this.mediaHash = hashPhoto;
        this.mediaType = typeMedia;
    }
    public MediaFile(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHash() {
        return mediaHash;
    }

    public void setHash(String hash) {
        this.mediaHash = hash;
    }

    public TypeMediaFile getMediaType() {
        return mediaType;
    }

    public void setMediaType(TypeMediaFile mediaType) {
        this.mediaType = mediaType;
    }

    public UserAllData getUserAllData() {
        return userAllData;
    }

    public void setUserAllData(UserAllData userAllData) {
        this.userAllData = userAllData;
    }
}
