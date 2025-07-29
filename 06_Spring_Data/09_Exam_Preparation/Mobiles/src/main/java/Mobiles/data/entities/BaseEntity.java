package Mobiles.data.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected BaseEntity() { }

    public void setId(Long id) {
        this.id = id;
    }
}
