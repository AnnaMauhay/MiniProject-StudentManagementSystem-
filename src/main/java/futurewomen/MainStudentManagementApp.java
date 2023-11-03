package futurewomen;

import futurewomen.CourseManagement.CourseManagement;
import futurewomen.StudentInformationManagement.StudentManagement;
import futurewomen.UserManagement.UserManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

import static futurewomen.Utils.Constants.APP_HEADER;
import static futurewomen.Utils.Constants.SERIALIZED_USER_LIST;

public class MainStudentManagementApp {
    boolean isLoggedIn = false;
    boolean quit = false;

    public void run() {
        System.out.println(APP_HEADER);
        while (!quit) {
            displayMainMenu();
        }


//        while (!quit) {
//            System.out.println("Next feature");
//            Scanner input = new Scanner(System.in);
//            input.nextLine();
//        }
    }

    private void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                MAIN MENU
                Please select the number of your choice:
                1 - User Management
                2 - Student Management
                3 - Course Management
                4 - Exit
                """);
        try {
            int selection = input.nextInt();
            input.nextLine();
            switch (selection) {
                case 1:
                    displayUserManagementUI();
                    break;
                case 2:
                    studentManagement();
                    break;
                case 3:
                    courseManagement();
                    break;
                case 4:
                    exitApp();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter integers only.");
        }
    }

    private void courseManagement() {
        System.out.println("Course Management");
        CourseManagement.deserializeOfferedCourses();
        Scanner input = new Scanner(System.in);
        boolean wantsBack = false;
        while (!wantsBack) {
            System.out.println("""
                    Please select the number of your choice:
                    1 - View Offered Courses
                    2 - Back
                    """);
            try {
                int selection = input.nextInt();
                input.nextLine();
                switch (selection) {
                    case 1:
                        CourseManagement.displayOfferedCourses();
                        break;
                    //TODO: implement UI for Course CRUD
                    case 2:
                        wantsBack=true;
                        CourseManagement.serializeOfferedCourses();
                        break;
                }
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter integers only.");
            }
        }
    }

    private void studentManagement() {
        System.out.println("Student Management");
        StudentManagement.deserializeStudentsList();
        Scanner input = new Scanner(System.in);
        boolean wantsBack = false;
        while (!wantsBack) {
            System.out.println("""
                    Please select the number of your choice:
                    1 - View All Students
                    2 - Back
                    """);
            try {
                int selection = input.nextInt();
                input.nextLine();
                switch (selection) {
                    case 1:
                        StudentManagement.displayStudents();
                        break;
                        //TODO: implement UI for Student CRUD
                    case 2:
                        wantsBack=true;
                        StudentManagement.serializeStudentsList();
                        break;
                }
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please enter integers only.");
            }
        }
    }

    private void displayUserManagementUI() {
        UserManagement.readUsersFromFile(SERIALIZED_USER_LIST);

        Scanner input = new Scanner(System.in);
        boolean wantsBack = false;
        while (!isLoggedIn && !wantsBack) {
            System.out.println("""
                    Please select the number of your choice:
                    1 - Login
                    2 - Register as new User
                    3 - Display Users
                    4 - Back
                    """);
            try {
                int selection = input.nextInt();
                input.nextLine();
                switch (selection) {
                    case 1:
                        displayLoginUI();
                        break;
                    case 2:
                        displayRegistrationUI();
                        break;
                    case 3:
                        UserManagement.displayUsers();
                        break;
                        //TODO: Implement UI for User Management Update and Delete
                    case 4:
                        wantsBack=true;
                        UserManagement.saveUsersToFile(SERIALIZED_USER_LIST);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter integers only.");
                input.nextLine();
            }
        }
    }

    private void exitApp() {
        System.out.println("Goodbye!");
        quit=true;
    }

    private void displayRegistrationUI() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your username.");
        String userName = input.nextLine();
        System.out.println("Please enter your password.");
        String password = input.nextLine();

        if (UserManagement.registerNewUser(userName, password)){
            System.out.println("You have successfully registered.");
        }
        else System.out.println("Please try again.");
        input.nextLine();
    }

    private void displayLoginUI() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your username.");
        String userName = input.nextLine();
        System.out.println("Please enter your password.");
        String password = input.nextLine();
        isLoggedIn = UserManagement.login(userName, password);

        if (isLoggedIn) System.out.println("You have successfully logged in");
        else System.out.println("Sorry, incorrect username and/or password.");
        input.nextLine();
    }
}