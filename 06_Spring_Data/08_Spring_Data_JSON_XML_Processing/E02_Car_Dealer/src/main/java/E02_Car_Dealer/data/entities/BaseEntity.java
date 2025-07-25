package E02_Car_Dealer.data.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected BaseEntity() { }

    public Long getId() {
        return id;
    }
}
