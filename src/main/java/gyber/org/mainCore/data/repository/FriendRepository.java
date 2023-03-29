package gyber.org.mainCore.data.repository;

import gyber.org.mainCore.data.entities.Friend;
import gyber.org.mainCore.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend , Long> {

    default boolean addUserFriend(Long userId , Long friendUserId){



        return false;
    }

    default boolean deleteFriendUser(Long userId , Long friendId){


        return false;
    }


}
