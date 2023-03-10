package DatabaseManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import General.*;

class CourseManager extends DatabaseManager<Course> {
    protected CourseManager() {}

    @Override
    public ArrayList<Course> readFile() {
        String filePath = "src/Database/Courses.tmp";
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            try {
                ArrayList<Course> courses = (ArrayList<Course>) ois.readObject();
                return courses;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeFile(ArrayList<Course> courses) {

    }

    @Override
    public void view() {

    }

    @Override
    public void remove(Course course) {
        
    }

    @Override
    public void add(Course course) {

    }

    @Override
    public void edit(Course course) {

    }
}
