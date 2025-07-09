package E01_Products_Shop.repositories;

import E01_Products_Shop.data.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.nio.file.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
