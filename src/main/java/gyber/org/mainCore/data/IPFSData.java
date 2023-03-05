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

    @OneToOne(mappedBy = "ipfsData")
    private UserAllData userAllData;

}
