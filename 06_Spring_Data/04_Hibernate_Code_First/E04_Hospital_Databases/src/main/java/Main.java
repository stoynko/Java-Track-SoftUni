import jakarta.persistence.*;

public class Main {

/* Congrats! You were hired as a Junior Database App Developer. But before starting to work you were required to provide some documents such as a fit note from your GP.
So, you go to him to get it. When you tell him, what you need and what kind of job you are about to start, he told you that he was just looking for someone to make software to help him
manage and keep data about his patients. He offered to give you the fit note for free if you help him. You thought that’s a great opportunity to save 20 leva and go out with friends tonight.
Also, it would expand your portfolio with 1 project.

Your task is to design a database using the Code First approach. The GP needs to keep information about his patients.
    •	Each patient has a first name, last name, address, email, date of birth, picture, information on whether he has medical insurance or not.
    •	The GP should also keep a history of all his visitations, diagnoses and prescribed medicaments.
    •	Each visitation has a date and comments.
    •	Each diagnose has a name and comments for it.
    •	Each medicament has a name.

Make sure all data is validated before inserting it into the database.

Bonus Task:
    •	Make console based user interface, which the doctor can use easily with the database. */

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hospital-db");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}