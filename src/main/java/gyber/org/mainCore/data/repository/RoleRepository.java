package gyber.org.mainCore.data.repository;

import gyber.org.mainCore.data.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName (String name);
}
