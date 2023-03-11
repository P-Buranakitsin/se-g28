package Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Enums.*;
import General.*;

public class PopulateDB {

    public static void poulateTeachersDB() {
        String filePath = "src/Database/Teachers.tmp";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            ArrayList<Teacher> teachers = new ArrayList<>();
            ArrayList<Skill> skills = new ArrayList<Skill>();
            skills.add(new Skill(SkillName.JAVA.toString()));
            skills.add(new Skill(SkillName.CLOUD_COMPUTING.toString()));
            Teacher teacher = new Teacher("James", "Bond", new Degree(DegreeLevel.BACHELOR, FieldOfStudy.COMPUTING_SCIENCE), skills, WorkingDay.FRIDAY);
            Teacher teacher2 = new Teacher("Jake", "Mccune", new Degree(DegreeLevel.MASTER, FieldOfStudy.CHEMISTRY), new ArrayList<Skill>(), WorkingDay.THURSDAY);
            Teacher teacher3 = new Teacher("Tobey", "Maguire", new Degree(DegreeLevel.BACHELOR, FieldOfStudy.MATHS), new ArrayList<Skill>(), WorkingDay.WEDNESDAY);
            teachers.add(teacher);
            teachers.add(teacher2);
            teachers.add(teacher3);
            oos.writeObject(teachers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void populateCoursesDB() {
        String filePath = "src/Database/Courses.tmp";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            ArrayList<Course> courses = new ArrayList<>();
            ArrayList<Skill> skills = new ArrayList<Skill>();
            skills.add(new Skill(SkillName.JAVA.toString()));
            skills.add(new Skill(SkillName.PYTHON.toString()));
            skills.add(new Skill(SkillName.GIT.toString()));
            Course course = new Course(CourseName.DATABASE, new Requirement(WorkingDay.FRIDAY,skills, new Degree(DegreeLevel.BACHELOR, FieldOfStudy.COMPUTING_SCIENCE)));
            Course course2 = new Course(CourseName.ENTERPRISE_CYBER_SECURITY, new Requirement(WorkingDay.MONDAY,new ArrayList<Skill>(),new Degree(DegreeLevel.BACHELOR, FieldOfStudy.CHEMISTRY)));
            Course course3 = new Course(CourseName.PROGRAMMING, new Requirement(WorkingDay.WEDNESDAY,new ArrayList<Skill>(),new Degree(DegreeLevel.BACHELOR, FieldOfStudy.CHEMISTRY)));
            Course course4 = new Course(CourseName.SOFTWARE_ENGINEERING, new Requirement(WorkingDay.TUESDAY,new ArrayList<Skill>(),new Degree(DegreeLevel.BACHELOR, FieldOfStudy.CHEMISTRY)));
            courses.add(course);
            courses.add(course2);
            courses.add(course3);
            courses.add(course4);
            oos.writeObject(courses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
