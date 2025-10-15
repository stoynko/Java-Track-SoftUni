package main.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Setter @Getter @NoArgsConstructor
@Entity
@Table(name = "mobs")
public class Mob {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level", nullable = true)
    private int level;

    @Column(name = "health", nullable = true)
    private double health;

    @Column(name = "attack", nullable = true)
    private double attack;

    @Column(name = "defense", nullable = true)
    private double defense;

    @Column(name = "alive", nullable = true)
    private boolean alive;

    @Column(name = "adena_drop", nullable = true)
    private int adenaDrop;

    @Column(name = "xp_drop", nullable = true)
    private int xpDrop;

    @Column(name = "type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private MobType type;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "spawn_area", nullable = false)
    private String spawnArea;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;

}


