package services;

import entities.User;
import factories.UserFactory;

import java.util.List;

public class UserService {

    private List<User> users;

    public UserService() {
        users = UserFactory.createUsers();

    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String username) {

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public User login(String username, String password) {

        User user = getUser(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    public User createUser(String username, String password) {

        if (username == null || username.isBlank()) {
            return null;
        }

        if (password == null || password.isBlank() || !validatePassword(password)) {
            return null;
        }


        if (getUser(username) != null) {
            return null;
        }

        User user = new User(username, password);
        addUser(user);

        return user;
    }

    private boolean validatePassword(String psw){
        if (psw.length() < 8 || psw.length() > 15)
            return false;
        else
            return true;
    }
}