package lld.splitwise;

import lld.splitwise.entities.*;

import java.util.List;

public class ExpenseFactory {

    public static Expense getExpense(ExpenseType type, String expenseName, double amount, List<User> users, User paidBy){
        switch (type){
            case EQUAL:
                return new EqualExpense(expenseName, amount, users, paidBy);
            case UNEQUAL:
                return new UnequalExpense(expenseName, amount, users, paidBy);
            case PERCENTAGE:
                return new PercentageExpense(expenseName, amount, users, paidBy);
        }
        return null;
    }

}
