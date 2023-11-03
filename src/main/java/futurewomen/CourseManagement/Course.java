package futurewomen.CourseManagement;

import com.google.gson.Gson;
import futurewomen.StudentInformationManagement.Student;

import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable {
    private int courseID;
    private String name;

    public Course(int courseID, String name) {
        this.courseID = courseID;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name==null?"":name.replaceAll("\\s", "").toLowerCase(),
                courseID);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false;
        if (obj instanceof Course course){
            return course.hashCode()==this.hashCode();
        }
        return false;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
