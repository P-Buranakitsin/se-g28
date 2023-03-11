package General;

import java.io.Serializable;

import Enums.*;
import Interfaces.*;

public class Course implements Storable, Serializable {
    private static int count = 0;
    private int id;
    private CourseName name;
    private Requirement requirement;
    private Teacher teacher;

    public Course(CourseName course,Requirement requirement) {
        this.name = course;
        this.requirement = requirement;
        this.teacher = null;
        this.id = ++count;
    }

    public CourseName getName() {
        return this.name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setName(CourseName name) {
        this.name = name;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }
    public String toString() {
        String skill = " ";
        for (Skill s : this.requirement.getSkills()) {
            skill += s.toString();
            skill += " ";
        }
        String t = "None";
        if (teacher != null) {
            t = teacher.toString();
        }
        return this.id + ": " + this.name + " "  + this.requirement.getTeachingDay() + skill + " taught by " + t;
    }

    public int getId() {
        return id;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
