package Mobiles.data.dto.sale;

import com.google.gson.annotations.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;

public class ImportSaleDTO {

    @Expose
    private Boolean discounted;

    @Expose
    @NotNull
    @Length(min = 7, max = 7)
    private String number;

    @Expose
    @NotNull
    private String saleDate;

    @Expose
    private Long seller;

    public ImportSaleDTO() { }

    public void setDiscounted(Boolean discounted) {
        this.discounted = discounted;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public void setSeller(Long seller) {
        this.seller = seller;
    }

    public Boolean getDiscounted() {
        return discounted;
    }

    public String getNumber() {
        return number;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public Long getSeller() {
        return seller;
    }
}
