package E01_SoftUni_Game_Store.service.dto;

import java.math.*;
import java.time.*;

public class GameDetailedViewDTO {

    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public GameDetailedViewDTO() { }

    public void setTitle(String title) {
        this.title = title;
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
