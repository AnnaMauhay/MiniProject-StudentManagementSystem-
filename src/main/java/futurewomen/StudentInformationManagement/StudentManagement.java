package futurewomen.StudentInformationManagement;

import futurewomen.CourseManagement.Course;
import futurewomen.Utils.CRUD;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static futurewomen.Utils.Constants.*;

public class StudentManagement {
    private static List<Student> studentsList = new ArrayList<>();

    public static boolean addStudent(Student student){
        CRUD<Student> crud = new CRUD<>();
        return crud.add(student,studentsList);
    }
    public static boolean deleteStudent(Student student){
        CRUD<Student> crud = new CRUD<>();
        return crud.delete(student,studentsList);
    }

    public static void serializeStudentsList(){
        CRUD<Student> crud = new CRUD<>();
        crud.serialize(studentsList, Path.of(DESTINATION_SERIALIZED_OBJ+SERIALIZED_STUDENTS_LIST));
    }

    public static void deserializeStudentsList(){
        CRUD<Student> crud = new CRUD<>();
        studentsList = crud.deserialize(Path.of(DESTINATION_SERIALIZED_OBJ+SERIALIZED_STUDENTS_LIST));
    }

    public static void displayStudents(){
        studentsList.forEach(System.out::println);
    }

}
