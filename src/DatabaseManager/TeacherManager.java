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
                Teacher teacher = (Teacher)ois.readObject();
                System.out.println(teacher.getFirstName());
                System.out.println(teacher.getLastName());
                System.out.println(teacher.getDegree().getLevel());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Scanner s = new Scanner(rd);
            // ArrayList<Teacher> teachers = new ArrayList<>();
            // while (s.hasNextLine()) {
            //     String[] tuple = s.nextLine().split(",");
            //     String firstName = tuple[0];
            //     String lastName = tuple[1];
            //     DegreeLevel degreeLevel = Enums.DegreeLevel.valueOf(tuple[2]);
            //     FieldOfStudy fieldOfStudy = Enums.FieldOfStudy.valueOf(tuple[3]);
            //     /* No more than three skills */
            //     for (int i = 4; i < 7 ; i++) {
            //         if (!tuple[i].isEmpty()) {
            //             skills.add(new Skill(tuple[i]));
            //         }
            //     }
                
            // }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeFile(String fileName, ArrayList<Teacher> teachers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\Database\\Teachers.tmp"))) {
            Teacher teacher = new Teacher("James", "Bond", DegreeLevel.DOCTORAL);
            oos.writeObject(teacher);
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
