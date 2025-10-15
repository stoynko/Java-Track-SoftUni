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
@Table(name = "quests")
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "xp", nullable = false)
    private double xp;

    @Column(name = "banner_url", nullable = false, unique = true)
    private String bannerUrl;

    @Column(name = "eligible_class", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PlayerClass eligibleClass;

    @ManyToOne(targetEntity = Item.class)
    @JoinColumn(name = "reward_item_id")
    private Item rewardItem;

    @ManyToOne(targetEntity = Player.class)
    @JoinColumn(name = "capturer_id")
    private Player capturer;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

}

