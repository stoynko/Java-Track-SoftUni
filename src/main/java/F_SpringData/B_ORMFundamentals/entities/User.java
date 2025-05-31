package F_SpringData.B_ORMFundamentals.entities;

import F_SpringData.B_ORMFundamentals.orm.core.*;

import java.time.*;

@Entity(name = "users")
public class User {

    @Id
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "under_age")
    private Boolean underAge;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "download_ratio")
    private Double downloadRatio;

    public User() {}

    public User(String userName, String password, int age, LocalDate registrationDate) {
        this.username = userName;
        this.password = password;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getUnderAge() {
        return underAge;
    }

    public void setUnderAge(Boolean underAge) {
        this.underAge = underAge;
    }

    public Double getDownloadRatio() {
        return downloadRatio;
    }

    public void setDownloadRatio(Double downloadRatio) {
        this.downloadRatio = downloadRatio;
    }
}
