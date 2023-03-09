package DatabaseManager;

import java.util.ArrayList;
import General.*;
import Interfaces.*;

public class DatabaseManager {
    
    protected ArrayList<Teacher> teachers;
    protected ArrayList<Course> courses;

    public DatabaseManager() {
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void assignTeacherToCourse(Teacher teacher, Course course) {

    }

    /* To be overidden */
    public void readFile(String fileName) {}
    public void writeFile(String fileName, ArrayList<Storable> storables) {}
    public void view() {}
    public void remove(Storable storable) {}
    public void add(Storable storable) {}
    public void edit(Storable storable) {}

}
