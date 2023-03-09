package DatabaseManager;

import java.util.ArrayList;
import General.*;

public class TeacherManager extends DatabaseManager<Teacher> {
    public TeacherManager() {
        super();
    }

    @Override
    public ArrayList<Teacher> readFile(String fileName) {
        return null;
    }

    @Override
    public void writeFile(String fileName, ArrayList<Teacher> teachers) {

    }

    @Override
    public void view() {

    }

    @Override
    public void remove(Teacher teacher) {
        System.out.println(teacher.getFirstName());
    }

    @Override
    public void add(Teacher teacher) {
        
    }

    @Override
    public void edit(Teacher teacher) {

    }
}
