package Database;

import Database.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);
    List<User> findByUsernameContaining(String username);
    List<User> findByAgeGreaterThan(int age);
    List<User> findByCity(String city);





}
