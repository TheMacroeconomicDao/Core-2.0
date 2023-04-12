package gyber.org.mainCore.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users_all_data")
@Data
@Slf4j
public class UserAllData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userID;
    private String userAvatarPath;
    private Date logInUserDate;
    private Date onlineInDate;
    private String aboutUs;
    private String skills;
    private String companies;
    private Date dateOfBirthday;


    @OneToOne(mappedBy = "userAllData")
    private User user;

//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ipfs_data_user_id" , referencedColumnName = "id")
//    private IPFSData ipfsData;


    @OneToMany(mappedBy = "userAllData", cascade = CascadeType.ALL)
    private List<MediaFile> mediaFilesUserList;


    @OneToMany(mappedBy = "userAllData", cascade = CascadeType.ALL)
    private List<Friend> friends;


//    @OneToMany
//    private List<Notification>notifications;

    /**
     * AllArgsConstructor - "lombok" (Aomisha).
     * @param userAvatarPath ...
     * @param logInUserDate ...
     * @param onlineInDate ...
     * @param aboutUs ...
     * @param skills ...
     * @param companies ...
     * @param dateOfBirthday ...
     */
    public UserAllData(String userAvatarPath, Date logInUserDate, Date onlineInDate, String aboutUs, String skills,
                       String companies, Date dateOfBirthday) {
        this.userAvatarPath = userAvatarPath;
        this.logInUserDate = logInUserDate;
        this.onlineInDate = onlineInDate;
        this.aboutUs = aboutUs;
        this.skills = skills;
        this.companies = companies;
        this.dateOfBirthday = dateOfBirthday;
//        this.ipfsData = ipfsData;
    }

    /**
     * NoArgsConstructor - "lombok" (Aomisha).
     */
    public UserAllData() {

    }


//    public List<Friend> getFriends() {
//        return friends;
//    }
//
//    public void setFriends(List<Friend> friends) {
//        this.friends = friends;
//    }


//    public IPFSData getIpfsData() {
//        return ipfsData;
//    }
//
//    public void setIpfsData(IPFSData ipfsData) {
//        this.ipfsData = ipfsData;
//    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @param mediaFile ...
     */
    public void addMediaFile(MediaFile mediaFile) {
        log.info("Method addMediaFile from UserAllData.class");

        if (this.mediaFilesUserList == null) {
            this.mediaFilesUserList = new ArrayList<>();
            this.mediaFilesUserList.add(mediaFile);
        }

        this.mediaFilesUserList.add(mediaFile);

    }

    /**
     * Не знаю за что отвечает метод(Aomisha).
     * @param friend ...
     */
    public void addFriend(Friend friend) {
        log.info("Method addFriend from UserAllData.class");

        if (this.friends == null) {
            this.friends = Collections.singletonList(friend);
        }
        this.friends.add(friend);
    }
}
