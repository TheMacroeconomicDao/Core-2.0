package gyber.org.mainCore.data.repository;

import gyber.org.mainCore.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByNickNameOrEmail(String emailOrNickname, String nickNameOrEmail);
    Optional<User> findByNickName(String nickname);

    default void addUserFriendToList(Long userId , Long friendUserId){


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

    default void deleteFriendUserInList(Long userId , Long friendId){
        User user = findById(userId).orElseThrow();

        /// ...


    }

}
