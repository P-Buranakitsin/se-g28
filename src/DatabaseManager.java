import java.util.ArrayList;

public class DatabaseManager {
    
    protected ArrayList<Teacher> teachers;
    protected ArrayList<Course> courses;

    public DatabaseManager(ArrayList<Teacher> teachers, ArrayList<Course> courses) {
        this.teachers = teachers;
        this.courses = courses;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    private void assignTeacherToCourse(Teacher teacher, Course course) {

    }

    /* To be overidden */
    protected void readFile(String fileName) {}
    protected void writeFile(String fileName, ArrayList<Storable> storables) {}
    protected void view() {}
    protected void remove(Storable storable) {}
    protected void add(Storable storable) {}
    protected void edit(Storable storable) {}

}
