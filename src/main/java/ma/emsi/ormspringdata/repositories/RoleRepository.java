package ma.emsi.ormspringdata.repositories;

import ma.emsi.ormspringdata.entities.Role;
import ma.emsi.ormspringdata.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName (String rolename);
}
