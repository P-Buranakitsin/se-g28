package Utils;

import java.util.ArrayList;

import DatabaseManager.DatabaseManager;
import General.*;
import Interfaces.*;

public class TeacherMatcher {

    public static void assignTeacherToCourse(DatabaseManager<Teacher> tManager, DatabaseManager<Course> cManager , int teacherId, int courseId) {
        ArrayList<Teacher> teachers = tManager.readFile();
        ArrayList<Course> courses = cManager.readFile();
        Course course = null;
        Teacher teacher = null;
        for (Course c : courses) {
            if(c.getId() == courseId) course = c;
        }
        for (Teacher t : teachers) {
            if(t.getId() == teacherId) teacher = t;
        }
        course.setTeacher(teacher);
        teacher.setCourse(course);
        cManager.edit(courseId, course);
        tManager.edit(teacherId, teacher);
    }

    public static ArrayList<Teacher> findMatchedTeachers(ArrayList<Teacher> teachers, Course course) {  
        ArrayList<Teacher> result = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (!teacher.getAvailableDay().toString().equals(course.getRequirement().getTeachingDay().toString())) {
                continue;
            }
            if (!teacher.getDegree().toString().equals(course.getRequirement().getDegree().toString())) {
                continue;
            }
            result.add(teacher);
        }
        return result;
    }

}
