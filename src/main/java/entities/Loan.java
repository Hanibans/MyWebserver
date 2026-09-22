package entities;
import java.time.LocalDate;

public class Loan {
    private User user;
    private Book book;
    private LocalDate date;

    public Loan(User user, Book book, LocalDate date) {
        this.user = user;
        this.book = book;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDate() {
        return date;
    }
}