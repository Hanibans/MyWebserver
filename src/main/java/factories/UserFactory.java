package factories;

import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    public static List<User> createUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("Hannah", "Kode8642"));
        users.add(new User("Sarah", "Kode4321"));
        users.add(new User("Amna", "Kode6543"));
        users.add(new User("Zenib", "Kode1234"));
        users.add(new User("Joshua", "Kode4567"));
        users.add(new User("Timothy", "Kode9876"));
        users.add(new User("Zazie", "Kode1234"));
        users.add(new User("Isaiah", "Kode6543"));
        users.add(new User("Jasper", "Kode4321"));
        users.add(new User("Bruce", "Kode2345"));

        return users;
    }




}
