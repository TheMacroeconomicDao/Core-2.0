package gyber.org.mainCore.data;

import jakarta.persistence.*;

@Entity
@Table(name = "users_ipfs_data")
public class IPFSData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "ipfsData")
    private UserAllData userAllData;

}
