package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "card_type", length = 16, nullable = false)
    private String cardType;

    @Column(name = "expiration_month", nullable = false)
    private byte expirationMonth;

    @Column(name = "expiration_year", nullable = false)
    private byte expirationYear;

    public CreditCard() { }

    public void setId(long id) {
        this.id = id;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setExpirationMonth(byte expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public void setExpirationYear(byte expirationYear) {
        this.expirationYear = expirationYear;
    }

    public long getId() {
        return id;
    }

    public String getCardType() {
        return cardType;
    }

    public byte getExpirationMonth() {
        return expirationMonth;
    }

    public byte getExpirationYear() {
        return expirationYear;
    }
}
