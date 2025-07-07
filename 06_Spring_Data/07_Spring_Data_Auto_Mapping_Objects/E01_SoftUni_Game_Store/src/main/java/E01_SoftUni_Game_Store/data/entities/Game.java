package E01_SoftUni_Game_Store.data.entities;

import jakarta.persistence.*;

import java.math.*;
import java.time.*;
import java.util.*;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Double.compare(size, game.size) == 0 && Objects.equals(title, game.title) && Objects.equals(trailerURL, game.trailerURL) && Objects.equals(imageThumbnailURL, game.imageThumbnailURL) && Objects.equals(price, game.price) && Objects.equals(description, game.description) && Objects.equals(releaseDate, game.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, trailerURL, imageThumbnailURL, size, price, description, releaseDate);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public void setImageThumbnailURL(String imageThumbnailURL) {
        this.imageThumbnailURL = imageThumbnailURL;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public String getImageThumbnailURL() {
        return imageThumbnailURL;
    }

    public double getSize() {
        return size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
