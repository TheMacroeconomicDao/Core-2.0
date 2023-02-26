package gyber.org.mainCore.data;

import gyber.org.mainCore.data.notifications.Notification;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users_all_data")
public class UserAllData {



    @Id
    private Long userID;
    private String userAvatarPath;
    private Date logInUserDate;
    private Date onlineInDate;
    private String aboutUs;
    private String skills;
    private String companies;
    private Date dateOfBirthday;
    private IPFSData ipfsData;


    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Friend> friends;


    @OneToMany
    private List<Notification>notifications;






    public UserAllData(String userAvatarPath, Date logInUserDate, Date onlineInDate, String aboutUs, String skills, String companies, Date dateOfBirthday, IPFSData ipfsData) {
        this.userAvatarPath = userAvatarPath;
        this.logInUserDate = logInUserDate;
        this.onlineInDate = onlineInDate;
        this.aboutUs = aboutUs;
        this.skills = skills;
        this.companies = companies;
        this.dateOfBirthday = dateOfBirthday;
        this.ipfsData = ipfsData;
    }

    public UserAllData(){

    }


    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

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

    public IPFSData getIpfsData() {
        return ipfsData;
    }

    public void setIpfsData(IPFSData ipfsData) {
        this.ipfsData = ipfsData;
    }
}
