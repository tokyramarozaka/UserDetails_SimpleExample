package school.hei.helloworldapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.hei.helloworldapi.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}
