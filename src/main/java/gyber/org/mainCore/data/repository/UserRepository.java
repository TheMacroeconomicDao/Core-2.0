package gyber.org.mainCore.data.repository;

import gyber.org.mainCore.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   User findUserByNickName(String userNickName);
    Optional<User> findByEmail(String email);
    Optional<User> findByNickNameOrEmail(String emailOrNickname, String nickNameOrEmail);
    Optional<User> findByNickName(String nickname);

    default void addUserFriendToList(Long userId , Long friendUserId) {}


}
