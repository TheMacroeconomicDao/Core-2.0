package gyber.org.mainCore.data;


import jakarta.persistence.*;

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


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
}
