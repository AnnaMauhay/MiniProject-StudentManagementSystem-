package futurewomen;

import futurewomen.UserManagement.UserManagement;

public class Main {
    public static void main(String[] args) {
//        StudentManagementSystem app = new StudentManagementSystem();
//        app.run();
//        testUserManagementCRUD();
//        UserManagement.saveUsersToFile("UserList.txt");
        UserManagement.readUsersFromFile("UserList.txt").forEach(System.out::println);
    }

    private static void testUserManagementCRUD() {
        UserManagement.registerNewUser("Anna", "pass");
        UserManagement.registerNewUser("Liza", "pass");
        UserManagement.updateUsername("Liza", "pass", "Lizabells");
        UserManagement.deleteUser("Anna", "pass");
        UserManagement.registerNewUser("Amanda", "pass2");
        UserManagement.displayUsers();
    }
}
