package E01_SoftUni_Game_Store.service.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;

import java.math.*;
import java.time.*;

public class CreateGameDTO {

    @Length(min = 3, max = 100)
    @Pattern
    (regexp = "^[A-Z]{1}.*",
    message = "Game title has to start with an uppercase letter.")
    private String title;

    @Length(min = 10, max = 11)
    private String trailerURL;

    @Pattern
    (regexp = "/^(?:http[s]?:\\/\\/.)?(?:www\\.)?[-a-zA-Z0-9@%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b(?:[-a-zA-Z0-9@:%_\\+.~#?&\\/\\/=]*)$",
    message = "The URL should start with an http or https protocol.")
    private String imageThumbnailURL;

    @Positive
    private double size;

    @Positive
    private BigDecimal price;

    @Length(min = 20)
    private String description;

    private LocalDate releaseDate;

    public CreateGameDTO() { }

    public CreateGameDTO(String title, String trailerURL, String imageThumbnailURL, double size, BigDecimal price, String description, LocalDate releaseDate) {
        this.title = title;
        this.trailerURL = trailerURL;
        this.imageThumbnailURL = imageThumbnailURL;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
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
