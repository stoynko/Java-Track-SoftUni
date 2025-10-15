package main.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "role", nullable = true)
    @Enumerated(value = EnumType.STRING)
    private PlayerRole role;

    @Column(name = "player_class", nullable = true)
    @Enumerated(value = EnumType.STRING)
    private PlayerClass playerClass;

    @Column(name = "xp")
    private double xp;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;

    public int getLevel() {
        return (int) (this.xp / 10) + 1;
    }

    public double getProgress() {
        return Math.max(1, ((this.xp % 10) / 10.0) * 100);
    }
}

