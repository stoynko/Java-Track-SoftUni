package entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    @Basic
    private String email;

    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    @OneToMany(mappedBy = "teacher", targetEntity = Course.class)
    private List<Course> coursesToTeach;

    public Teacher() { super(); }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public void setCoursesToTeach(List<Course> coursesToTeach) {
        this.coursesToTeach = coursesToTeach;
    }

    public String getEmail() {
        return email;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public List<Course> getCoursesToTeach() {
        return coursesToTeach;
    }
}
