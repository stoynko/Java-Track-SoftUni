package main.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ItemType type;

    @Column(name = "xp_bonus_multiplier", nullable = true)
    private double xpBonusMultiplier;

    @Column(name = "icon_url", nullable = false, unique = true)
    private String iconUrl;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    public String getXpFormatted() {
        return String.format("%s - x%.1f XP", this.type.getItemType(), this.xpBonusMultiplier);
    }

    public String getTypeAndXpFormatted() {
        return String.format("%s – x%.1f XP", this.type, this.xpBonusMultiplier);
    }
}

