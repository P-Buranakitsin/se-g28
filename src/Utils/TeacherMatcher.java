package Utils;

import java.util.ArrayList;

import DatabaseManager.DatabaseManager;
import General.*;
import Interfaces.*;

public class TeacherMatcher {

    public static void assignTeacherToCourse(ArrayList<Teacher> teachers, ArrayList<Course> courses , Teacher teacher, Course course) {
        // ArrayList<Teacher> teachers = tManager.readFile();
        // ArrayList<Course> courses = cManager.readFile();
        int teacherIndex = teachers.indexOf(teacher);
        int courseIndex = courses.indexOf(course);
        teacher.setCourse(course);
        course.setTeacher(teacher);
        teachers.set(teacherIndex, teacher);
        courses.set(courseIndex, course);
        // tManager.writeFile(teachers);
        // cManager.writeFile(courses);
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
