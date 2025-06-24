package E02_User_System.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name", nullable = false)
    @Size(min = 4, max = 30, message = "Username must be between 4 and 30 characters.")
    private String userName;

    @Column(nullable = false)
    @Size(min = 6, max = 50, message = "Password should be between 6 and 50 symbols and contain at least one " +
                                       "lowercase, uppercase, digit and a special symbol;")
    private String password;

    public User() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
