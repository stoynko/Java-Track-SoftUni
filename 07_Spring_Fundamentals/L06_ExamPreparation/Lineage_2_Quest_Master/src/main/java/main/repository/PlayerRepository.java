package main.repository;

import main.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {

    List<Player> findAll();

    Optional<Player> findPlayerByUsername(String username);

    Player findPlayerById(UUID playerId);

    List<Player> findAllByRole(PlayerRole playerRole);


    List<Player> getAllByRoleOrderByXpDesc(PlayerRole playerRole);

    List<Quest> findAllByPlayerClass(PlayerClass playerClass);
}
