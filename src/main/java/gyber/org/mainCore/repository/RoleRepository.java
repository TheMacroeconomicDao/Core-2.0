package gyber.org.mainCore.repository;

import gyber.org.mainCore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Метод для поиска роли из БД по имени роли.
     * @param name имя роли
     * @return возвращение роли из БД
     */
    Role findByName(String name);
}
