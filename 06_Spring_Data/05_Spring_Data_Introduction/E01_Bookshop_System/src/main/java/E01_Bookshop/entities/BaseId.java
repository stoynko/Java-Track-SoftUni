package E01_Bookshop.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    public Long getId() {
        return id;
    }

    protected BaseId() { }
}