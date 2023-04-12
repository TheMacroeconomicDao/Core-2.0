package gyber.org.mainCore.repository;

import gyber.org.mainCore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Получение пользователя по почте.
     * @param email почта пользователя
     * @return возвращает пользователя
     */
    User findByEmail(String email);

    /**
     * Получение пользователя по никнейму или почте.
     * @param emailOrNickname почта или никнейм пользователя
     * @param nickNameOrEmail почта или никнейм пользователя
     * @return возвращает пользователя
     */
    User findByNickNameOrEmail(String emailOrNickname, String nickNameOrEmail);

    /**
     * Получение пользователя по никнейму.
     * @param nickname никнейм пользователя
     * @return возвращает пользователя
     */
    User findByNickName(String nickname);

    /**
     * Неизвестно что за метод (Аomisha).
     * @param userId id пользователя
     * @param friendUserId id пользователя
     */
    default void addUserFriendToList(Long userId, Long friendUserId) {


//        User user = findById(userId).orElseThrow();
//        User userFriend = findById(friendUserId).orElseThrow();
//
//        Friend friend = new Friend(userFriend);
//
//        user
//                .getUserAllData()
//                .getFriends()
//                .add(friend);
//
//        save(user);
    }

    /**
     * Неизвестно что за метод (Аomisha).
     * @param userId id пользователя
     * @param friendId id пользователя
     */
    default void deleteFriendUserInList(Long userId, Long friendId) {

        User user = findById(userId).orElseThrow();

        /// ...


    }

}
