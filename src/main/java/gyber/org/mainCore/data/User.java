package gyber.org.mainCore.data;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String firstName;
    private String lastName;

    private String nickName;

    private String email;
    private String passwd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_all_data_id" , referencedColumnName = "id")
    private UserAllData userAllData;



    public User(String firstName, String lastName, String nickName, String email, String passwd, UserAllData userAllData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.email = email;
        this.passwd = passwd;
        this.userAllData = userAllData;
    }


    public User(String email , String firstName , String lastName , String passwd){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwd = passwd;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserAllData getUserAllData() {
        return userAllData;
    }

    public void setUserAllData(UserAllData userAllData) {
        this.userAllData = userAllData;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", userAllData=" + userAllData +
                '}';
    }
}
