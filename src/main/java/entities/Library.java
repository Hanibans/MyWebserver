package entities;

import factories.BookFactory;
import factories.UserFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Library {
    private static Library instance = new Library();

    private List<Book> books;
    private List<User> users;
    private List<Loan> loans;

    public static Library getInstance() {
        return instance;
    }

    private Library() {
        books = BookFactory.createBooks();
        users = UserFactory.createUsers();
        loans = new ArrayList<>();
        Random random = new Random();
        for(User user:users){
            for(int i=0; i<10; i++){
                addLoan(new Loan(user, books.get(random.nextInt(books.size()-1)), LocalDate.now()));
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
        loan.getUser().addLoan(loan);
    }
}