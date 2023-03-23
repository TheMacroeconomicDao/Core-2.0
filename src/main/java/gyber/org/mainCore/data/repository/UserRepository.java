package gyber.org.mainCore.data.repository;

import gyber.org.mainCore.data.entities.Friend;
import gyber.org.mainCore.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   User findUserByNickName(String userNickName);

}
