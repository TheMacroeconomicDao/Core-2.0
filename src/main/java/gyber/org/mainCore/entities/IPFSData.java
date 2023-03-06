package gyber.org.mainCore.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users_ipfs_data")
public class IPFSData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @OneToMany(mappedBy = "ipfsData" , cascade = CascadeType.ALL)
    private List<MediaFile>mediaFiles;

    @OneToOne(mappedBy = "ipfsData")
    private UserAllData userAllData;


    public IPFSData(List<MediaFile> mediaFiles, UserAllData userAllData) {
        this.mediaFiles = mediaFiles;
        this.userAllData = userAllData;
    }

    public IPFSData(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MediaFile> getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(List<MediaFile> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    public UserAllData getUserAllData() {
        return userAllData;
    }

    public void setUserAllData(UserAllData userAllData) {
        this.userAllData = userAllData;
    }
}
