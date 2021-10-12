package boot.repository;

import boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByPhone(String phoneNumber);

    User getUserById(long id);
}
