package E01_Bookshop_System.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    protected BaseId() { }
}