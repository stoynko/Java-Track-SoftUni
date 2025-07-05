package E01_SoftUni_Game_Store.service.dto;

import jakarta.validation.constraints.*;

import java.math.*;

public class EditGameDTO {

    private long id;

    @Positive
    private BigDecimal price;

    @Positive
    private double size;

    public EditGameDTO() { }

    public EditGameDTO(long id, BigDecimal price, double size) {
        this.id = id;
        this.price = price;
        this.size = size;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    public long getId() {
        return id;
    }
}
