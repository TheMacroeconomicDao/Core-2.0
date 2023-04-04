package gyber.org.mainCore.data.entities;

import gyber.org.mainCore.data.entities.enums.ProfileDeactivateStatus;
import gyber.org.mainCore.data.entities.enums.Role;
import gyber.org.mainCore.data.repository.UserRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String firstName;
    private String lastName;

    private String nickName;

    @Email(message = "Email is Invalid")
    private String email;

    private String passwd;

    @Enumerated(EnumType.STRING)
    private ProfileDeactivateStatus profileStatus;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_all_data_id" , referencedColumnName = "id")
    private UserAllData userAllData;
    @Enumerated(EnumType.STRING)
    private Role role;


    //Импелентирумые методы UserDetails


    @Override
    public String getPassword() {
        return passwd;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        if(email.isEmpty()) {
            return nickName;
        } else {
            return email;
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(nickName, user.nickName) && Objects.equals(email, user.email) && Objects.equals(passwd, user.passwd) && Objects.equals(userAllData, user.userAllData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, nickName, email, passwd, userAllData);
    }

}
