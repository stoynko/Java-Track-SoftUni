package main.service;

import main.config.mappers.PlayerMapper;
import main.model.Player;
import main.model.PlayerClass;
import main.model.PlayerRole;
import main.model.Quest;
import main.repository.PlayerRepository;
import main.web.dto.LoginRequest;
import main.web.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PlayerService {


    private final PasswordEncoder passwordEncoder;
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PasswordEncoder passwordEncoder, PlayerMapper playerMapper, PlayerRepository playerRepository) {
        this.passwordEncoder = passwordEncoder;
        this.playerRepository = playerRepository;
    }

    public void registerUser(RegisterRequest registerRequest) {

        Player player = Player.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .nickname(registerRequest.getNickname())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();

        playerRepository.saveAndFlush(player);
    }

    public Player login(LoginRequest loginRequest) {

        Player player = playerRepository.findPlayerByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User with username %s does not exist".formatted(loginRequest.getUsername())));

        String rawPassword = loginRequest.getPassword();
        String hashedPassword = player.getPassword();

        if (!passwordEncoder.matches(rawPassword, hashedPassword)) {
            throw new RuntimeException("Username and/or password is incorrect.");
        }

        return player;
    }

    public void selectRole(UUID playerId, PlayerRole playerRole) {
        Player player = playerRepository.findPlayerById(playerId);
        player.setRole(playerRole);

        if (playerRole == PlayerRole.ADVENTURER) {
            int randomIndex = new Random().nextInt(0, PlayerClass.values().length);
            player.setPlayerClass(PlayerClass.values()[randomIndex]);
        }

        player.setUpdatedOn(LocalDateTime.now());
        playerRepository.saveAndFlush(player);
    }

    public Player getById(UUID playerId) {
        return playerRepository.findPlayerById(playerId);
    }

    public List<Player> getAllAdventurers() {
        return playerRepository.getAllByRoleOrderByXpDesc(PlayerRole.ADVENTURER);
    }

    public List<Quest> findEligibleQuests(PlayerClass playerClass) {
        return playerRepository.findAllByPlayerClass(playerClass);
    }

    public void update(Player player) {
        playerRepository.saveAndFlush(player);
    }
}
