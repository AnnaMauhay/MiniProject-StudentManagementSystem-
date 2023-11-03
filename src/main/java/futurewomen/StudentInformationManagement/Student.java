package futurewomen.StudentInformationManagement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import futurewomen.CourseManagement.Course;
import futurewomen.UserManagement.User;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Student implements Serializable {

    private int studentID;
    private String name;
    private List<Course> enrolledCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name==null?"":name.replaceAll("\\s", "").toLowerCase(),
                enrolledCourses,
                studentID);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false;
        if (obj instanceof Student student){
            return student.hashCode()==this.hashCode();
        }
        return false;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
