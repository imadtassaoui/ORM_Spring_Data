package ma.emsi.ormspringdata.repositories;

import ma.emsi.ormspringdata.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername (String username);
}
