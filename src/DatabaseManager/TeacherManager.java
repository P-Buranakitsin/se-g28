package DatabaseManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import General.*;
import Enums.*;

public class TeacherManager extends DatabaseManager<Teacher> implements Serializable {
    private ArrayList<Skill> skills;

    public TeacherManager() {
        this.skills = new ArrayList<>();
    }

    @Override
    public ArrayList<Teacher> readFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\Database\\Teachers.tmp"))) {
            try {
                ArrayList<Teacher> teachers = (ArrayList<Teacher>)ois.readObject();
                
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeFile(String fileName, ArrayList<Teacher> teachers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\Database\\Teachers.tmp"))) {
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void view() {

    }

    @Override
    public void remove(Teacher teacher) {
        
    }

    @Override
    public void add(Teacher teacher) {
        
    }

    @Override
    public void edit(Teacher teacher) {

    }
}
