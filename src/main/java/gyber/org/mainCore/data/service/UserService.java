package gyber.org.mainCore.data.service;

import gyber.org.mainCore.data.entities.Role;
import gyber.org.mainCore.data.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
