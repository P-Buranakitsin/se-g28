package Utils;

import java.util.ArrayList;
import DatabaseManager.DatabaseManager;
import General.*;

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
        ArrayList<Skill> courseSet = course.getRequirement().getSkills();
        ArrayList<Skill> teacherSet = teacher.getSkills();
        for (int i = 0; i < courseSet.size(); i++) {
            for (int j = 0; j < teacherSet.size(); j++) {
                if(courseSet.get(i).toString().equals(teacherSet.get(j).toString())) {
                    courseSet.remove(i);
                    i--;
                    break;
                }
            }
        }
        teacher.setMissingSkills(courseSet);
        course.setTeacher(teacher);
        teacher.setCourse(course);
        cManager.edit(courseId, course);
        tManager.edit(teacherId, teacher);
    }

    public static void viewNonTeacher(DatabaseManager<Course> cManager) {
        ArrayList<Course> courses = cManager.readFile();
        if (courses != null) {
            for (Course course : courses) {
                if (course.getTeacher() != null) {
                    continue;
                }
                System.out.println(course.toString());
            }
        } else {
            System.out.println("There is no course in this database.");
        }
    }

    public static void viewHasTeacher(DatabaseManager<Course> cManager) {
        ArrayList<Course> courses = cManager.readFile();
        if (courses != null) {
            for (Course course : courses) {
                if (course.getTeacher() == null) {
                    continue;
                }
                System.out.println(course.toString());
            }
        } else {
            System.out.println("There is no course in this database.");
        }
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

    public static void removeAssignedTeacher(DatabaseManager<Teacher> tManager, DatabaseManager<Course> cManager, int courseId) {
        ArrayList<Teacher> teachers = tManager.readFile();
        ArrayList<Course> courses = cManager.readFile();
        Course course = null;
        Teacher teacher = null;
        for (Course c : courses) {
            if(c.getId() == courseId) course = c;
        }
        int teacherId = course.getTeacher().getId();
        for (Teacher t : teachers) {
            if(t.getId() == teacherId) teacher = t;
        }
        course.setTeacher(null);
        teacher.setCourse(null);
        teacher.setMissingSkills(null);
        cManager.edit(courseId, course);
        tManager.edit(teacherId, teacher);
    }

}
s