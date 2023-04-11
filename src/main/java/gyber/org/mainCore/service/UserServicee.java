//package gyber.org.mainCore.service;
//
//import gyber.org.mainCore.entity.Role;
//import gyber.org.mainCore.entity.User;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public interface UserService {
//    /**
//     * Сохранение пользователя.
//     * @param user данные о пользователе
//     * @return сохраняем в БД входящего пользователя
//     */
//    User saveUser(User user);
//
//    /**
//     * Сохранение роли.
//     * @param role данные о роли
//     * @return сохраняем в БД входящую роль
//     */
//    Role saveRole(Role role);
//
//    /**
//     * Добавление роли к пользователю.
//     * @param username никнейм или почта пользователя
//     * @param roleName имя роли
//     */
//    void addRoleToUser(String username, String roleName);
//
//    /**
//     * Получение пользователя по никнейму или почте.
//     * @param username никнейм или почта пользователя
//     * @return получаем пользователя
//     */
//    User getUser(String username);
//
//    /**
//     * Получение всех пользователей.
//     * @return возвращаем лист пользователей
//     */
//    List<User> getUsers();
//}
