package gyber.org.mainCore.repository;

import gyber.org.mainCore.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    /**
     * Добавление пользователя в друзья.
     * @param userId id пользователя принимающего заявку
     * @param friendUserId id пользователя подающего заявку
     * @return возвращает да или нет
     */
    default boolean addUserFriend(Long userId, Long friendUserId) {


        return false;
    }

    /**
     * Удаление друга из друзей.
     * @param userId id пользователя удаляющего
     * @param friendId id пользователя которого удаляют
     * @return возвращает да или нет
     */
    default boolean deleteFriendUser(Long userId, Long friendId) {


        return false;
    }


}
