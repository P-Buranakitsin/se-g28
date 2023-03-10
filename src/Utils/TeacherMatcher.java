package Utils;

import java.util.ArrayList;

import DatabaseManager.DatabaseManager;
import General.*;
import Interfaces.*;

public class TeacherMatcher {

    public static void assignTeacherToCourse(DatabaseManager<Teacher> tManager, DatabaseManager<Course> cManager , Teacher teacher, Course course) {
        ArrayList<Teacher> teachers = tManager.readFile();
        ArrayList<Course> courses = cManager.readFile();
        int teacherIndex = teachers.indexOf(teacher);
        int courseIndex = courses.indexOf(course);
        teacher.setCourse(course);
        course.setTeacher(teacher);
        teachers.set(teacherIndex, teacher);
        courses.set(courseIndex, course);
        tManager.writeFile(teachers);
        cManager.writeFile(courses);
    }

    public static ArrayList<Storable> findMatchedTeachers(ArrayList<Teacher> teachers, ArrayList<Course> courses) {  
        return null;
    }

}
