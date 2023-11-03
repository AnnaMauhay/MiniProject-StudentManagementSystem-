package futurewomen.CourseManagement;

import futurewomen.StudentInformationManagement.Student;
import futurewomen.Utils.CRUD;

import java.nio.file.Path;
import java.util.*;

import static futurewomen.Utils.Constants.DESTINATION_SERIALIZED_OBJ;
import static futurewomen.Utils.Constants.SERIALIZED_OFFERED_COURSE;

public class CourseManagement {
    private static List<Course> offeredCourses = new ArrayList<>();

    record CourseGradeRec(Student student, Course course, Float grade) {
        @Override
        public String toString() {
            return "CourseGradeRec{" +
                    "student=" + student +
                    ", course=" + course +
                    ", grade=" + grade +
                    '}';
        }
    }

    private static Map<Student, List<CourseGradeRec>> enrolledStudents = new HashMap<>();

    public static void enrollStudentToCourse(Student student, Course course) {
        if (enrolledStudents.containsKey(student)) {
            if (enrolledStudents.get(student).stream().noneMatch(
                    courseGradeRec -> courseGradeRec.course.equals(course))) {
                enrolledStudents.get(student).add(new CourseGradeRec(student, course, 0f));
            } else System.out.println("Student is already enrolled to this course.");
        } else {
            List<CourseGradeRec> courseGradeRecList = new ArrayList<>();
            courseGradeRecList.add(new CourseGradeRec(student, course, 0f));
            enrolledStudents.put(student, courseGradeRecList);
        }
    }

    public static void updateGrade(Student student, Course course, Float grade){
        if (enrolledStudents.containsKey(student)) {
            if (enrolledStudents.get(student).stream().noneMatch(
                    courseGradeRec -> courseGradeRec.course.equals(course))) {
                System.out.println("Student is not enrolled to this course.");
            } else {
                enrolledStudents.get(student).removeIf(courseGradeRec -> courseGradeRec.course.equals(course));
                enrolledStudents.get(student).add(new CourseGradeRec(student, course, grade));
            }
        }else System.out.println("Student is not enrolled to any course.");
    }

    public static void displayStudentGrades(Student student){
        enrolledStudents.get(student).forEach(System.out::println);
    }

    public static void displayStudentsInCourse(Course course){
        List<Student> students = new ArrayList<>();
        List<CourseGradeRec> courseGradeRecList = new ArrayList<>();
        enrolledStudents.values().forEach(courseGradeRecList::addAll);
        List<CourseGradeRec> enrolledInCourse = courseGradeRecList.stream().filter(courseGradeRec -> courseGradeRec.course.equals(course))
                .toList();
        enrolledInCourse.forEach(courseGradeRec -> students.add(courseGradeRec.student()));
        students.forEach(System.out::println);
    }

    public static boolean addOfferedCourse(Course course) {
        CRUD<Course> crud = new CRUD<>();
        return crud.add(course, offeredCourses);
    }

    public static boolean deleteOfferedCourse(Course course) {
        CRUD<Course> crud = new CRUD<>();
        return crud.delete(course, offeredCourses);
    }

    public static void serializeOfferedCourses() {
        CRUD<Course> crud = new CRUD<>();
        crud.serialize(offeredCourses, Path.of(DESTINATION_SERIALIZED_OBJ + SERIALIZED_OFFERED_COURSE));
    }

    public static void deserializeOfferedCourses() {
        CRUD<Course> crud = new CRUD<>();
        offeredCourses = crud.deserialize(Path.of(DESTINATION_SERIALIZED_OBJ + SERIALIZED_OFFERED_COURSE));
    }

    public static void displayOfferedCourses() {
        offeredCourses.forEach(System.out::println);
    }
}
