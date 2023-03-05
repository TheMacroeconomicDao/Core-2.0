package gyber.org.mainCore.data;

import jakarta.persistence.*;

@Entity
@Table(name = "users_ipfs_data")
public class IPFSData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String projectPath;

    private String photosHash;

    private String videosHash;




    @OneToOne(mappedBy = "ipfsData")
    private UserAllData userAllData;


    @Override
    public String toString() {
        return "IPFSData{" +
                "id=" + id +
                ", projectPath='" + projectPath + '\'' +
                ", photosHash='" + photosHash + '\'' +
                ", videosHash='" + videosHash + '\'' +
                ", userAllData=" + userAllData +
                '}';
    }
}
