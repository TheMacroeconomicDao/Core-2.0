package gyber.org.mainCore.entity;

import gyber.org.mainCore.entity.enums.TypeMediaFile;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "users_media_files")
@Data
public class MediaFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mediaHash;

    @Enumerated(EnumType.STRING)
    private TypeMediaFile mediaType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserAllData userAllData;

    /**
     * Constructor with any arguments.
     * @param hashPhoto ...
     * @param typeMedia ...
     */
    public MediaFile(String hashPhoto, TypeMediaFile typeMedia) {
        this.mediaHash = hashPhoto;
        this.mediaType = typeMedia;
    }

    /**
     * Constructor.
     */
    public MediaFile() {
    }


}
