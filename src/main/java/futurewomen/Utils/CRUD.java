package futurewomen.Utils;

import futurewomen.CourseManagement.Course;
import futurewomen.StudentInformationManagement.Student;
import futurewomen.UserManagement.User;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static futurewomen.Utils.Constants.DESTINATION_SERIALIZED_OBJ;

public class CRUD<T> {
    public boolean add(T obj, List<T> objList) {
        if (obj == null || objList == null || objList.contains(obj)) return false;
        return objList.add(obj);
    }

    public boolean delete(T obj, List<T> objList) {
        if (obj == null || objList == null || !objList.contains(obj)) return false;
        return objList.remove(obj);
    }

    public boolean serialize(List<T> obj, Path pathName) {
        try (ObjectOutputStream outObj = new ObjectOutputStream(
                new FileOutputStream(pathName.toFile()))) {
            outObj.writeObject(obj);
            System.out.println("...Object serialized successfully.\n");
            return true;
        } catch (IOException e) {
            System.out.println("Object serialization failed. " + e.getMessage());
        }
        return false;
    }

    public List<T> deserialize(Path pathName) {
        List<T> obj = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(pathName.toFile()))) {
            obj = (List<T>) in.readObject();
            System.out.println("...Object deserialized successfully.\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Object deserialization failed. " + e.getMessage());
        }
        return obj;
    }
}
