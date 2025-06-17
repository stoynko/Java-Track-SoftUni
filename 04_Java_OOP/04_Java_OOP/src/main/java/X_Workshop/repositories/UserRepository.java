package X_Workshop.repositories;

import D_Java_OOP.X_Workshop.entities.user.*;

import java.util.*;

public class UserRepository implements Repository<User, UUID> {

    private Map<UUID, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    @Override
    public void save(UUID id, User user) {
        this.users.put(id, user);
    }

    @Override
    public User getById(UUID id) {
        return this.users.get(id);
    }

    @Override
    public List<User> getAll() {
        return this.users.values().stream().toList();
    }
}
