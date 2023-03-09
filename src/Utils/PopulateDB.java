package Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Enums.DegreeLevel;
import General.Teacher;

public class PopulateDB {
    public static void poulateDB() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\Database\\Teachers.tmp"))) {
            ArrayList<Teacher> teachersTest = new ArrayList<>();
            Teacher teacher = new Teacher("James", "Bond", DegreeLevel.DOCTORAL);
            Teacher teacher2 = new Teacher("Jake", "Mccune", DegreeLevel.MASTER);
            teachersTest.add(teacher);
            teachersTest.add(teacher2);
            oos.writeObject(teachersTest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
