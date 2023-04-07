package gyber.org.mainCore.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String passwd;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_all_data_id" , referencedColumnName = "id")
    private UserAllData userAllData;


//    public User(String firstName, String lastName, String nickName, String email, String passwd, UserAllData userAllData) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.nickName = nickName;
//        this.email = email;
//        this.passwd = passwd;
//        this.userAllData = userAllData;
//    }


    public User(String email , String firstName , String lastName , String passwd){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwd = passwd;
    }

    public User(String email , String firstName , String nickName, String lastName , String passwd, Collection<Role> roles){
        this.email = email;
        this.nickName = nickName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwd = passwd;
        this.roles = roles;
    }

}
