package lld.splitwise.entities;

import java.util.List;

public class Group {
    private String groupName;
    private List<Expense> expenseList;

    private List<User> groupMembers;

    public void addMember(User user) {
        groupMembers.add(user);
    }
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public List<User> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<User> groupMembers) {
        this.groupMembers = groupMembers;
    }
}
