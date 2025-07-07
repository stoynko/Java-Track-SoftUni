package E01_SoftUni_Game_Store.data.repositories;

import E01_SoftUni_Game_Store.data.entities.*;
import E01_SoftUni_Game_Store.service.dto.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface GamesRepository extends JpaRepository<Game, Long> {

    Game findById(long gameID);
    Game findByTitle(String title);
    boolean existsById(long gameID);
    boolean existsByTitle(String title);
    void deleteGameById(Long gameID);
}
