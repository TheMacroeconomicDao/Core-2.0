package gyber.org.mainCore.data.repository;
import gyber.org.mainCore.data.entities.UsersFriends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<UsersFriends, Long> {



}
