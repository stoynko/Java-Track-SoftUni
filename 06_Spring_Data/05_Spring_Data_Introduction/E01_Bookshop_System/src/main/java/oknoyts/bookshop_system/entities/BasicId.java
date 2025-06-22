package oknoyts.bookshop_system.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class BasicId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public BasicId() { }
}
