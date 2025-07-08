package E01_Products_Shop.data;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.*;

import java.util.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name")
    @Length(min = 3)
    private String lastName;

    @Column(nullable = true)
    private byte age;

    @ManyToMany()
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;

    public User() {
        this.friends = new HashSet<>();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public byte getAge() {
        return age;
    }

    public Set<User> getFriends() {
        return friends;
    }
}
