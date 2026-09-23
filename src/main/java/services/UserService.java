package services;

import entities.Library;
import entities.User;

import java.util.List;

public class UserService {

    private Library library = Library.getInstance();

    public UserService() {

    }

    public void addUser(User user) {
        library.addUser(user);
    }

    public User getUser(String username) {

        for (User user : library.getUsers()) {
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

    public List<User> getAllUsers() {
        return library.getUsers();
    }
}