package gyber.org.mainCore.data.entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users_friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String avatarPath;
    private String nickName;


    @Transient
    private User user;


    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private UserAllData userAllData;

    public Friend(){}




    public Friend(User user) {
        this.user = user;
        this.name = user.getFirstName();
        this.lastName = user.getLastName();
        this.avatarPath = user.getUserAllData().getUserAvatarPath();
        this.nickName = user.getNickName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAllData getUserAllData() {
        return userAllData;
    }

    public void setUserAllData(UserAllData userAllData) {
        this.userAllData = userAllData;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avatarPath='" + avatarPath + '\'' +
                ", nickName='" + nickName + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(id, friend.id) && Objects.equals(name, friend.name) && Objects.equals(lastName, friend.lastName) && Objects.equals(avatarPath, friend.avatarPath) && Objects.equals(nickName, friend.nickName) && Objects.equals(user, friend.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, avatarPath, nickName, user);
    }
}
