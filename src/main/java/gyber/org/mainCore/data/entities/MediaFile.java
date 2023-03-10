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

    @ManyToOne(fetch = FetchType.EAGER)
    private IPFSData ipfsData;



    public MediaFile(String hashPhoto , TypeMediaFile typeMedia) {
        this.mediaHash = hashPhoto;
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


    @Override
    public String toString() {
        return "MediaFile{" +
                "id=" + id +
                ", mediaHash='" + mediaHash + '\'' +
                ", mediaType=" + mediaType +
                ", ipfsData=" + ipfsData +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediaFile mediaFile = (MediaFile) o;
        return Objects.equals(id, mediaFile.id) && Objects.equals(mediaHash, mediaFile.mediaHash) && mediaType == mediaFile.mediaType && Objects.equals(ipfsData, mediaFile.ipfsData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mediaHash, mediaType, ipfsData);
    }
}
