package lld.splitwise.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public abstract class Expense {

    private LocalDateTime createdAt;
    private String expenseName;
    private double amount;
    private ExpenseType expenseType;
    Map<User, Double> shares;
    List<User> users;
    User paidBy;

    public Expense(String expenseName, double amount, ExpenseType expenseType, List<User> users, User paidBy){
        this.expenseName = expenseName;
        this.amount = amount;
        this.users = users;
        this.paidBy = paidBy;
    }

    public abstract Map<User, Double> getShares();

}
