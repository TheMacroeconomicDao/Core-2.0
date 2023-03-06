package gyber.org.mainCore.data.repository;

import gyber.org.mainCore.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

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
