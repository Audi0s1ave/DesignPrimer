package lld.splitwise.entities;

import java.util.List;
import java.util.Map;

public class PercentageExpense extends Expense{
    public PercentageExpense(String expenseName, double amount, List<User> users, User paidBy) {
        super(expenseName, amount, ExpenseType.PERCENTAGE, users, paidBy);
    }

    @Override
    public Map<User, Double> getShares() {
        // compute shares
        return this.shares;
    }
}
