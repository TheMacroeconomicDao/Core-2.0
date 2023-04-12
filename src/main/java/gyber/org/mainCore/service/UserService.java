package gyber.org.mainCore.service;

import gyber.org.mainCore.entity.Role;
import gyber.org.mainCore.entity.User;
import gyber.org.mainCore.repository.RoleRepository;
import gyber.org.mainCore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Получение пользователя из БД и его роли, если не находим в БД,
     * то выбрасываем исключение.
     * @param username никнейм или почта пользователя
     * @return получаем пользователя с паролоем и ролью для проверки доступа
     * @throws UsernameNotFoundException ошибка если пользователь не найден в БД
     */
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        log.info("Method UserDetails from UserService.class");

        User user = userRepository.findByNickNameOrEmail(username, username);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: ", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getNickName(), user.getPasswd(), authorities);
    }

    /**
     * Сохраняем пользователя в БД.
     * @param user данные о пользователе
     * @return сохраняем в БД входящего пользователя и шифруем пароль
     */

    public User saveUser(User user) {
        log.info("Method saveUser from UserService.class");

        log.info("Saving new user {} to the database", user.getNickName());
        user.setPasswd(passwordEncoder.encode(user.getPasswd()));
        return userRepository.save(user);
    }

    /**
     * Сохраняем роль в БД.
     * @param role данные о роли
     * @return сохраняем роль в БД
     */

    public Role saveRole(final Role role) {
        log.info("Method saveRole from UserService.class");

        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    /**
     * Добавляем роль пользователю по его никнейму или почте.
     * @param username никнейм или почта пользователя
     * @param roleName имя роли
     */

    public void addRoleToUser(String username, String roleName) {
        log.info("Method addRoleToUser from UserService.class");

        log.info("Add new role {} to user {} to the database", roleName, username);
        User user = userRepository.findByNickNameOrEmail(username, username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    /**
     * Получение пользовалея по почте или никнейму.
     * @param username никнейм или почта пользователя
     * @return
     */

    public User getUser(String username) {
        log.info("Method getUser from UserService.class");

        log.info("Fetching user {}", username);
        return userRepository.findByNickNameOrEmail(username, username);
    }

    /**
     * Получить всех пользователей.
     * @return получаем лист пользователей.
     */

    public List<User> getUsers() {
        log.info("Method getUsers from UserService.class");

        log.info("Fetching all users");
        return userRepository.findAll();
    }

}
