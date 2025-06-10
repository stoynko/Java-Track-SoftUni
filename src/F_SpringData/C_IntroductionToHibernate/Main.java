package F_SpringData.C_IntroductionToHibernate;

import jakarta.persistence.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
    }
}
