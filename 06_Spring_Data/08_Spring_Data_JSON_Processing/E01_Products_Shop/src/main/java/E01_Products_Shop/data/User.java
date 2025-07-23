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

    @ManyToMany
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;

    @OneToMany(mappedBy = "seller", targetEntity = Product.class)
    Set<Product> sold;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(friends, user.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, sold);
    }

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

    public void setSold(Set<Product> soldProducts) {
        this.sold = soldProducts;
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

    public Set<Product> getSold() {
        return sold;
    }
}
