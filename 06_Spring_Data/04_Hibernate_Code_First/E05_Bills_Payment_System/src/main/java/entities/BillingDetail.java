package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "billing_details")
public class BillingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String number;

    @ManyToOne()
    private User user;

    public BillingDetail() { }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public User getUser() {
        return user;
    }
}
