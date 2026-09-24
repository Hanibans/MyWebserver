package services;

import entities.Book;
import entities.Library;
import entities.User;
import exceptions.IllegalUserDataException;

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

    public User createUser(String username, String password) throws IllegalUserDataException {

        if (username == null || username.isBlank()) {
            throw new IllegalUserDataException("Brugernavn må ikke være tomt eller blankt");
        }

        if (password == null || password.isBlank() || !validatePassword(password)) {
            throw new IllegalUserDataException("Password må ikke være tomt eller blankt");
        }


        if (getUser(username) != null) {
            return null;
        }

        User user = new User(username, password);
        addUser(user);

        return user;
    }

    boolean validatePassword(String psw){
        if (psw.length() < 8 || psw.length() > 15)
            return false;
        else
            return true;
    }

    public List<User> getAllUsers() {
        return library.getUsers();
    }

    public List<Book> getAllBooks() {
        return library.getBooks();
    }
}