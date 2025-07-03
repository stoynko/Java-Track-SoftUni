package E01_SoftUni_Game_Store.data.repositories;

import E01_SoftUni_Game_Store.data.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);
    Optional <User> findUserByEmailAndPassword(String email, String password);
}
