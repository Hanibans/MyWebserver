package services;

import entities.User;
import factories.UserFactory;

import java.util.List;

public class UserService {

    private List<User> users;

    public UserService() {
        this.users = UserFactory.createUsers();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        if (user == null){
            System.out.println("no users added");
        }

        users.add(user);
        System.out.println(user + "added!");

    }

    public User getUser(String username){
        if (username == null){
            System.out.println("no username found!");
        }

        for (User us: users){
            if (us.getUsername().equals(username)){
                return us;
            }
        }
        return null;
    }

    public User login(String username, String password){
        if (username == null || password == null){
            System.out.println("no login!");
            return null;
        }

        for (User login: users){
            if (login.getUsername().equals(username) &&
                    login.getPassword().equals(password)){
                System.out.println("Login succesful!");
                return login;
            }
        }

        return null;
    }

    public User createUser(String username, String password){
        if (username == null || password == null){
            System.out.println("no user created!");
        }

        if (!validatePassword(password)) {
            throw new IllegalArgumentException("Password must be 8-15 characters!");
        }

        for (User us: users) {
            if (us.getUsername().equals(username)) {
                return null;
            }
        }

        User user = new User(username,password);
        users.add(user);

        return user;

    }
    private boolean validatePassword(String password) {
        return password.length() >= 8 && password.length() <= 15;
    }



}
