package L02_Models.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String username;

    @Basic
    private int age;

    @OneToMany(mappedBy = "user", targetEntity = Account.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Account> accounts;

    public User() { }

    public User(String username, int age, List<Account> accounts) {
        this.username = username;
        this.age = age;
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return String.format("User: %s is %d years old and has the %d registered accounts.",
                username, age, accounts.size());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
