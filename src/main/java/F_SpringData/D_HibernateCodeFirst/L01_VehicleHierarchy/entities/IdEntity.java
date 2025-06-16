package main.java.F_SpringData.D_HibernateCodeFirst.L01_VehicleHierarchy.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class IdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public IdEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
