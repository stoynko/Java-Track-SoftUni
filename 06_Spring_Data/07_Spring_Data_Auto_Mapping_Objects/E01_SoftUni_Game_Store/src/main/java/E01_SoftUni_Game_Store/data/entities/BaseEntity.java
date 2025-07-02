package E01_SoftUni_Game_Store.data.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    protected BaseEntity() { }

    public long getId() {
        return id;
    }
}
