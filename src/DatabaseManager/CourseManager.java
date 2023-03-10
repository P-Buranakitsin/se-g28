package DatabaseManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        String filePath = "src/Database/Courses.tmp";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(courses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void view() {
        ArrayList<Course> courses = readFile();
        if (courses != null) {
            for (int i = 0; i < courses.size(); i++) {
                System.out.println(courses.get(i).toString());
            }
        } else {
            System.out.println("There is no course in this database.");
        }
    }

    @Override
    public void remove(int id) {
        ArrayList<Course> courses = readFile();
        for (Course course : courses) {
            if (course.getId() == id) {
                courses.remove(course);
                break;
            }
        }
        writeFile(courses);
    }

    @Override
    public void add(Course course) {
        ArrayList<Course> courses = readFile();
        courses.add(course);
        writeFile(courses);
    }

    @Override
    public void edit(int id, Course course) {
        ArrayList<Course> courses = readFile();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.set(i, course);
                break;
            }
        }
        writeFile(courses);
    }
}
