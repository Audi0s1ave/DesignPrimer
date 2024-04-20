package lld.splitwise.entities;

import java.util.List;
import java.util.Map;

public class EqualExpense extends Expense{
    public EqualExpense(String expenseName, double amount, List<User> users, User paidBy) {
        super(expenseName, amount, ExpenseType.EQUAL, users, paidBy);
    }

    @Override
    public Map<User, Double> getShares() {
        // compute
        return shares;
    }
}
