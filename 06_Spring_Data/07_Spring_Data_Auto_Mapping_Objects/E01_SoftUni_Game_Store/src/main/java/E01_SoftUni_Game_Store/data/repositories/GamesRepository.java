package E01_SoftUni_Game_Store.data.repositories;

import E01_SoftUni_Game_Store.data.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface GamesRepository extends JpaRepository<Game, Long> {

}
