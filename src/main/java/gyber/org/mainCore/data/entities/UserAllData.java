package gyber.org.mainCore.data.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "users_all_data")
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


    @OneToMany(mappedBy = "userAllData" , cascade = CascadeType.ALL)
    private List<MediaFile>mediaFilesUserList;




    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_friends" ,
            joinColumns = @JoinColumn(name = "user_id") ,
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private Set<User>usersFriends;


//    @OneToMany
//    private List<Notification>notifications;



    public UserAllData(String userAvatarPath, Date logInUserDate, Date onlineInDate, String aboutUs, String skills, String companies, Date dateOfBirthday) {
        this.userAvatarPath = userAvatarPath;
        this.logInUserDate = logInUserDate;
        this.onlineInDate = onlineInDate;
        this.aboutUs = aboutUs;
        this.skills = skills;
        this.companies = companies;
        this.dateOfBirthday = dateOfBirthday;
//        this.ipfsData = ipfsData;
    }

    public UserAllData(){

    }


//    public List<Friend> getFriends() {
//        return friends;
//    }
//
//    public void setFriends(List<Friend> friends) {
//        this.friends = friends;
//    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserAvatarPath() {
        return userAvatarPath;
    }

    public void setUserAvatarPath(String userAvatarPath) {
        this.userAvatarPath = userAvatarPath;
    }

    public Date getLogInUserDate() {
        return logInUserDate;
    }

    public void setLogInUserDate(Date logInUserDate) {
        this.logInUserDate = logInUserDate;
    }

    public Date getOnlineInDate() {
        return onlineInDate;
    }

    public void setOnlineInDate(Date onlineInDate) {
        this.onlineInDate = onlineInDate;
    }


    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getCompanies() {
        return companies;
    }

    public void setCompanies(String companies) {
        this.companies = companies;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

//    public IPFSData getIpfsData() {
//        return ipfsData;
//    }
//
//    public void setIpfsData(IPFSData ipfsData) {
//        this.ipfsData = ipfsData;
//    }



    public void addMediaFile(MediaFile mediaFile){

        if(this.mediaFilesUserList == null){
            this.mediaFilesUserList = new ArrayList<>();
            this.mediaFilesUserList.add(mediaFile);
        }

        this.mediaFilesUserList.add(mediaFile);

    }

//    public void addFriend(Friend friend){
//        if(this.friends == null){
//            this.friends = Collections.singletonList(friend);
//        }
//        this.friends.add(friend);
//    }

    public List<MediaFile> getMediaFilesUserList() {
        return mediaFilesUserList;
    }

    public void setMediaFilesUserList(List<MediaFile> mediaFilesUserList) {
        this.mediaFilesUserList = mediaFilesUserList;
    }

    public Set<User> getUsersFriends() {
        return usersFriends;
    }

    public void setUsersFriends(Set<User> usersFriends) {
        this.usersFriends = usersFriends;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//
//    @Override
//    public String toString() {
//        return "UserAllData{" +
//                "userID=" + userID +
//                ", userAvatarPath='" + userAvatarPath + '\'' +
//                ", logInUserDate=" + logInUserDate +
//                ", onlineInDate=" + onlineInDate +
//                ", aboutUs='" + aboutUs + '\'' +
//                ", skills='" + skills + '\'' +
//                ", companies='" + companies + '\'' +
//                ", dateOfBirthday=" + dateOfBirthday +
//                ", user=" + user +
//                ", mediaFilesUserList=" + mediaFilesUserList +
//                ", friends=" + friends +
//                '}';
//    }

    @Override
    public String toString() {
        return "UserAllData{" +
                "userID=" + userID +
                ", userAvatarPath='" + userAvatarPath + '\'' +
                ", logInUserDate=" + logInUserDate +
                ", onlineInDate=" + onlineInDate +
                ", aboutUs='" + aboutUs + '\'' +
                ", skills='" + skills + '\'' +
                ", companies='" + companies + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
//                ", user=" + user +
                ", mediaFilesUserList=" + mediaFilesUserList +
                ", friends=" + usersFriends +
                '}';
    }
}
