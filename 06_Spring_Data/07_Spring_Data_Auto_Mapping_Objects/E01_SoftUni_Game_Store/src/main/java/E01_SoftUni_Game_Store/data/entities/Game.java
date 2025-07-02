package E01_SoftUni_Game_Store.data.entities;

import jakarta.persistence.*;

import java.math.*;
import java.time.*;

@Entity
@Table(name = "games")
public class Game extends BaseEntity{

    @Basic
    private String title;

    @Column(name = "trailer_url")
    private String trailerURL;

    @Column(name = "thumbnail_url")
    private String imageThumbnailURL;

    @Basic
    private double size;

    @Basic
    private BigDecimal price;

    @Basic
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    public Game() { }


}
