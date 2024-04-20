package lld.splitwise;

import lld.splitwise.entities.User;
import java.util.List;

public class UserManager {

    private static UserManager userManager;
    static {
        userManager = new UserManager();
    }

    User createUser(){
        return new User();
    }

    public void addFriends(User a, List<User> b){
        // add friends
    }

    public void removeFriends(User a, List<User> b){
        // remove friends
    }

    public static UserManager getInstance(){
        return userManager;
    }

}
