package futurewomen;

import futurewomen.UserManagement.UserManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

import static futurewomen.Utils.Constants.APP_HEADER;

public class StudentManagementSystem {
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
    }

    private void studentManagement() {
        System.out.println("Student Management");
    }

    private void displayUserManagementUI() {
        Scanner input = new Scanner(System.in);
        boolean wantsBack = false;
        while (!isLoggedIn && !wantsBack) {
            System.out.println("""
                    Please select the number of your choice:
                    1 - Login
                    2 - Register as new User
                    3 - Back
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
                        wantsBack=true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter integers only.");
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