package E01_Bookshop.entities.interfaces;

import E01_Bookshop.entities.enums.*;

import java.math.*;

public interface BookInfo {
    String getTitle();
    EditionType getEditionType();
    AgeRestrictionType getAgeGroup();
    BigDecimal getPrice();
}
