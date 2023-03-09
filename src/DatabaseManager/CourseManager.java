package DatabaseManager;

import java.util.ArrayList;
import General.*;

public class CourseManager extends DatabaseManager<Course> {
    public CourseManager() {
        super();
    }

    @Override
    public ArrayList<Course> readFile(String fileName) {
        return null;
    }

    @Override
    public void writeFile(String fileName, ArrayList<Course> courses) {

    }

    @Override
    public void view() {

    }

    @Override
    public void remove(Course course) {
        System.out.println(course.getName());
    }

    @Override
    public void add(Course course) {

    }

    @Override
    public void edit(Course course) {

    }
}
