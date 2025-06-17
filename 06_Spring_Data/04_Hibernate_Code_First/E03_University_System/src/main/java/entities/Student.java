package entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "students")
public class Student extends Person {

    @Column(name = "average_grade")
    private double averageGrade;

    @Basic
    private short attendance;

    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private List<Course> courses;

    public Student() { super(); }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setAttendance(short attendance) {
        this.attendance = attendance;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public short getAttendance() {
        return attendance;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
