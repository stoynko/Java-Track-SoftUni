import entities.*;
import jakarta.persistence.*;

import java.time.*;
import java.util.*;

public class Main {

/* Your task is to create a database for a University System, using the Code First approach. In the database, we should keep information about students,
teachers and courses. The database should have the following tables:

    •	Student (id, first name, last name, phone number, average grade, attendance)
    •	Teacher (id, first name, last name, phone number, email, salary per hour)
    •	Course (id, name, description, start date, end date, credits)

The relationships between the tables are as follows:
    •	Each student can be enrolled in many courses and for each course many students can be enrolled.
    •	A teacher can teach in many courses but one course can be taught only by one teacher.

Use class hierarchy to reduce code duplication. */

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("university-db");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Teacher> teachers = createTeachers();
        List<Course> courses = createCourses(teachers);
        List<Student> students = createStudents(courses);

        teachers.forEach(entityManager::persist);
        courses.forEach(entityManager::persist);
        students.forEach(entityManager::persist);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Teacher> createTeachers() {
        Teacher teacherA = new Teacher();
        teacherA.setFirstName("Alan");
        teacherA.setLastName("Turing");
        teacherA.setPhoneNumber("+359888111111");
        teacherA.setEmail("alan.turing@university.edu");
        teacherA.setSalaryPerHour(120.0);

        Teacher teacherB = new Teacher();
        teacherB.setFirstName("Ada");
        teacherB.setLastName("Lovelace");
        teacherB.setPhoneNumber("+359888222222");
        teacherB.setEmail("ada.lovelace@university.edu");
        teacherB.setSalaryPerHour(130.0);

        return List.of(teacherA, teacherB);
    }

    public static List<Course> createCourses(List<Teacher> teachers) {
        Course courseA = new Course();
        courseA.setName("Introduction to Java");
        courseA.setDescription("Basics of Java programming");
        courseA.setStartDate(Instant.parse("2024-09-15T08:00:00Z"));
        courseA.setEndDate(Instant.parse("2025-01-15T08:00:00Z"));
        courseA.setCredits((byte) 5);
        courseA.setTeacher(teachers.get(0));

        Course courseB = new Course();
        courseB.setName("Data Structures in Java");
        courseB.setDescription("Understanding and implementing data structures");
        courseB.setStartDate(Instant.parse("2024-09-15T08:00:00Z"));
        courseB.setEndDate(Instant.parse("2025-01-15T08:00:00Z"));
        courseB.setCredits((byte) 6);
        courseB.setTeacher(teachers.get(1));

        Course courseC = new Course();
        courseC.setName("Spring Boot Fundamentals");
        courseC.setDescription("Learn how to develop REST APIs with Spring Boot");
        courseC.setStartDate(Instant.parse("2025-02-01T08:00:00Z"));
        courseC.setEndDate(Instant.parse("2025-06-01T08:00:00Z"));
        courseC.setCredits((byte) 7);
        courseC.setTeacher(teachers.get(0));

        teachers.get(0).setCoursesToTeach(List.of(courseA, courseC));
        teachers.get(1).setCoursesToTeach(List.of(courseB));

        return List.of(courseA, courseB, courseC);
    }

    public static List<Student> createStudents(List<Course> courses) {
        Student studentA = new Student();
        studentA.setFirstName("John");
        studentA.setLastName("Doe");
        studentA.setPhoneNumber("+359888333333");
        studentA.setAverageGrade(5.60);
        studentA.setAttendance((short) 95);
        studentA.setCourses(List.of(courses.get(0), courses.get(1)));

        Student studentB = new Student();
        studentB.setFirstName("Jane");
        studentB.setLastName("Smith");
        studentB.setPhoneNumber("+359888444444");
        studentB.setAverageGrade(6.00);
        studentB.setAttendance((short) 98);
        studentB.setCourses(List.of(courses.get(1), courses.get(2)));

        Student studentC = new Student();
        studentC.setFirstName("Emily");
        studentC.setLastName("Brown");
        studentC.setPhoneNumber("+359888555555");
        studentC.setAverageGrade(5.20);
        studentC.setAttendance((short) 87);
        studentC.setCourses(List.of(courses.get(0), courses.get(2)));

        return List.of(studentA, studentB, studentC);
    }
}