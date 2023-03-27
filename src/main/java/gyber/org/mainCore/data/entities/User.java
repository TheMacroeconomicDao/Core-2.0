package gyber.org.mainCore.data.entities;

import gyber.org.mainCore.data.entities.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

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
        return email;
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

}
