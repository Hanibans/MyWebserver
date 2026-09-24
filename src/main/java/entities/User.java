package entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String password;
    private boolean isAdmin;
    private List<Loan> loans;
    private List<Book> cart;


    public User(String username, String password) {
        this(username, password, false);
    }

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.loans = new ArrayList<>();
        this.cart = new ArrayList<>();
    }

    public void addToCart(Book book) {
        cart.add(book);
    }

    public void clearCart(){
        cart = new ArrayList<>();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Book> getCart() {
        return cart;
    }

    public void setCart(List<Book> cart) {
        this.cart = cart;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }
}
