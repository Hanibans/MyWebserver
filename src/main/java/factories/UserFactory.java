package factories;

import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    public static List<User> createUsers() {

        List<User> users = new ArrayList<>();

        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
        users.add(new User("user4", "password4"));
        users.add(new User("user5", "password5"));
        users.add(new User("user6", "password6"));
        users.add(new User("user7", "password7"));
        users.add(new User("user8", "password8"));
        users.add(new User("user9", "password9"));
        users.add(new User("user10", "password10"));

        return users;
    }
}