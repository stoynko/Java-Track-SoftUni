package E01_SoftUni_Game_Store.service.dto;

import java.math.*;

public class GameBasicViewDTO {

    private String title;
    private BigDecimal price;

    public GameBasicViewDTO() { }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
