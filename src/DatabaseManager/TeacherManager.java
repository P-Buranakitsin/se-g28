package DatabaseManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import General.*;

class TeacherManager extends DatabaseManager<Teacher> implements Serializable {

    protected TeacherManager() {}

    @Override
    public ArrayList<Teacher> readFile() {
        String filePath = "src/Database/Teachers.tmp";
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            try {
                ArrayList<Teacher> teachers = (ArrayList<Teacher>) ois.readObject();
                return teachers;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeFile(ArrayList<Teacher> teachers) {
        String filePath = "src/Database/Teachers.tmp";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(teachers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void view() {
        ArrayList<Teacher> teachers = readFile();
        if (teachers != null) {
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println(teachers.get(i).toString());
            }
        } else {
            System.out.println("There is no teacher in this database.");
        }
    }

    @Override
    public void remove(int index) {
        ArrayList<Teacher> teachers = readFile();
        teachers.remove(index);
        writeFile(teachers);
    }

    @Override
    public void add(Teacher teacher) {
        ArrayList<Teacher> teachers = readFile();
        teachers.add(teacher);
        writeFile(teachers);
    }

    @Override
    public void edit(int index, Teacher teacher) {
        ArrayList<Teacher> teachers = readFile();
        teachers.set(index, teacher);
        writeFile(teachers);
    }
}
