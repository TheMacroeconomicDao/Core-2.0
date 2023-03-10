package gyber.org.mainCore.data.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

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

    public IPFSData(List<MediaFile> mediaFiles){
        this.mediaFiles = mediaFiles;


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


    @Override
    public String toString() {
        return "IPFSData{" +
                "id=" + id +
                ", mediaFiles=" + mediaFiles +
                ", userAllData=" + userAllData +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IPFSData ipfsData = (IPFSData) o;
        return Objects.equals(id, ipfsData.id) && Objects.equals(mediaFiles, ipfsData.mediaFiles) && Objects.equals(userAllData, ipfsData.userAllData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mediaFiles, userAllData);
    }
}
