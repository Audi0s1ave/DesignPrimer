package lld.splitwise;

import lld.splitwise.entities.Expense;
import lld.splitwise.entities.Group;
import lld.splitwise.entities.User;

import java.util.List;

public class GroupManager {

    private GroupManager(){

    }

    private static GroupManager groupManager;
    static {
        groupManager = new GroupManager();
    }

    Group createGroup(){
        return new Group();
    }

    public void addMember(Group group, User user){
       group.addMember(user);
    }
    public void removeMember(Group group, User user){
        // remove member
    }

    public List<Expense> getExpenses(Group group){
        return group.getExpenseList();
    }

    public static GroupManager getInstance(){
        return groupManager;
    }

}
