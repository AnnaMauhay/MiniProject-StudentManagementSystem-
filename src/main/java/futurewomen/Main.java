package futurewomen;

import futurewomen.CourseManagement.Course;
import futurewomen.StudentInformationManagement.Student;
import futurewomen.StudentInformationManagement.StudentManagement;
import futurewomen.UserManagement.UserManagement;

public class Main {
    public static void main(String[] args) {
        MainStudentManagementApp app = new MainStudentManagementApp();
        app.run();

//        testUserManagementCRUD();
//        testStudentCoursePersistence();

    }

    private static void testStudentCoursePersistence() {
        UserManagement.saveUsersToFile("UserList.txt");
        UserManagement.readUsersFromFile("UserList.txt");

        Student st1 = new Student(1, "Anna");
        Student st2 = new Student(2, "Liza");
        Student st3 = new Student(3, "Bella");

        StudentManagement.addStudent(st1);
        StudentManagement.addStudent(st2);
        StudentManagement.addStudent(st3);
        StudentManagement.displayStudents();
        System.out.println("================");


        Course cr1 = new Course(1, "Science");
        Course cr2 = new Course(2, "Math");
        Course cr3 = new Course(3, "Language");
        StudentManagement.addOfferedCourse(cr1);
        StudentManagement.addOfferedCourse(cr2);
        StudentManagement.addOfferedCourse(cr3);
        StudentManagement.displayOfferedCourses();
        System.out.println("================");
        StudentManagement.serializeOfferedCourses();

        StudentManagement.serializeStudentsList();
        StudentManagement.deserializeStudentsList();
        StudentManagement.displayStudents();
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
