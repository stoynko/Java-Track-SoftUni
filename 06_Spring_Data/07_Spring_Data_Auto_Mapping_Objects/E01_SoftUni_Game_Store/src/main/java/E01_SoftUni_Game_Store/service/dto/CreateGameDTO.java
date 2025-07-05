package E01_SoftUni_Game_Store.service.dto;

import E01_SoftUni_Game_Store.data.common.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;

import java.math.*;
import java.time.*;

public class CreateGameDTO {

    @Length(min = 3, max = 100)
    @Pattern
    (regexp = "^[A-Z]{1}.*",
    message = SystemErrorMessage.INVALID_GAME_TITLE)
    private String title;

    @Length(min = 10, max = 11)
    private String trailerURL;

    @URL(message = SystemErrorMessage.INVALID_GAME_URL)
    private String imageThumbnailURL;

    @Positive
    private double size;

    @Positive
    private BigDecimal price;

    @Length(min = 20)
    private String description;

    private LocalDate releaseDate;

    public CreateGameDTO() { }

    public CreateGameDTO(String title, BigDecimal price, double size, String trailerURL, String imageThumbnailURL, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailerURL = trailerURL;
        this.imageThumbnailURL = imageThumbnailURL;
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
