package DatabaseManager;

import java.util.ArrayList;
import General.*;
import Interfaces.Storable;

public class TeacherManager extends DatabaseManager {
    public TeacherManager(ArrayList<Teacher> teachers, ArrayList<Course> courses) {
        super(teachers, courses);
    }

    @Override
    public void readFile(String fileName) {

    }

    @Override
    public void writeFile(String fileName, ArrayList<Storable> storables) {

    }

    @Override
    public void view() {

    }

    @Override
    public void remove(Storable storable) {

    }

    @Override
    public void add(Storable storable) {
        
    }

    @Override
    public void edit(Storable storable) {

    }
}
