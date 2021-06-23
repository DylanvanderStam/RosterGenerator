package user;

import java.util.ArrayList;

public class Login {
    private static Login single_instance = null;
    private User activeUser;

    private Login(User user) {
        activeUser = user;
    }

    public static Login getInstance(String username, String password, ArrayList<User> employees) {
        if(single_instance == null) {
            for(User temp : employees) {
                if (temp.getEmail().equals(username) && temp.getPassword().equals(password)) {
                    return new Login(temp);
                }
            }
        }
        return null;
    }

    public User getActiveUser() {
        return activeUser;
    }
}
