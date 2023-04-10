package gyber.org.mainCore.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users_friends")
@Data
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


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserAllData userAllData;

    public Friend() {
    }

    /**
     * Constructor with user.
     * @param user ...
     */
    public Friend(User user) {
        this.user = user;
        this.name = user.getFirstName();
        this.lastName = user.getLastName();
//        this.avatarPath = user.getUserAllData().getUserAvatarPath();
        this.nickName = user.getNickName();
    }
}
