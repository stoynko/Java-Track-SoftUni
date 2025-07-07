package E01_SoftUni_Game_Store.data.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.*;

import java.util.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Basic
    private String email;

    @Basic
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_games",
               joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
    private Set<Game> games;

    @Column(name = "admin")
    private boolean admin;

    @Transient
    private Set<Game> shoppingBasket;

    public User() {
        this.shoppingBasket = new HashSet<>();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public Set<Game> getGames() {
        return games;
    }

    public Set<Game> getShoppingBasket() {
        return shoppingBasket;
    }

    public boolean isAdmin() {
        return admin;
    }
}
