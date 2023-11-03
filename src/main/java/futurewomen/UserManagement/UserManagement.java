package futurewomen.UserManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/*
User Registration and Login using Java Methods
What to do: Create methods for registering a new user and logging in.
Store username and password in an array or list.

Expected: Two separate methods, one for registration and one for login.
New users should be stored in memory for now.

 */
public class UserManagement {
    private static List<String> userNameList = new ArrayList<>();
    private static List<String> passwordList = new ArrayList<>();

    public static boolean registerNewUser(String userName, String password) {
        if (userNameList.contains(userName)) {
            System.out.println("Username already taken.");
            return false;
        } else {
            userNameList.add(userName);
            passwordList.add(password);
            return true;
        }
    }

    public static boolean login(String userName, String password) {
        if(userNameList.contains(userName)) {
            return (passwordList.get(userNameList.indexOf(userName)).equals(password));
        }else return false;
    }
}
