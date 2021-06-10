package nl.firepy.basicwebapp.services;

import nl.firepy.basicwebapp.model.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class UserManager {

    private final Set<User> users = new HashSet<>();

    public UserManager() {
        users.add(new User("Tim", "Lamelot", 18));
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public Set<User> getUsers() {
        return users;
    }
}
