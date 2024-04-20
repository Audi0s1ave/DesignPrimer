package lld.splitwise.entities;

import java.util.List;
import java.util.Map;

public class UnequalExpense extends Expense{
    public UnequalExpense(String expenseName, double amount, List<User> users, User paidBy) {
        super(expenseName, amount, ExpenseType.UNEQUAL, users, paidBy);
    }

    @Override
    public Map<User, Double> getShares() {
        // compute
        return this.shares;
    }
}
