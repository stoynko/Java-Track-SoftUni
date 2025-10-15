package main.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="players")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "player_class", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PlayerClass playerClass;

    @Column(name = "banner_img", nullable = false)
    private String bannerImg;

    @ManyToOne(targetEntity = Player.class)
    private Party party;

    @Column(name = "level", nullable = true)
    private int level;

    @Column(name = "health", nullable = true)
    private double health;

    @Column(name = "attack", nullable = true)
    private double attack;

    @Column(name = "defense", nullable = true)
    private double defense;

    @Column(name = "xp", nullable = true)
    private double xp;

    @Column(name = "adena", nullable = true)
    private int adena;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;
}

