package L01_Shampoo_Company.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    private Long id;

    protected BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
