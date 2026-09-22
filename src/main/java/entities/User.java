package entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String password;
    private List<Loan> loans;


    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.loans = new ArrayList<>();
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
