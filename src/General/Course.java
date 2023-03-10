package General;

import java.io.Serializable;

import Enums.*;
import Interfaces.*;

public class Course implements Storable, Serializable {
    private CourseName name;
    private Requirement requirement;
    private Teacher teacher;

    public Course(CourseName course,Requirement requirement) {
        this.name = course;
        this.requirement = requirement;
    }

    public CourseName getName() {
        return this.name;
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
        String skill = "";
        for (Skill s : this.requirement.getSkills()) {
            skill += s.toString();
            skill += " ";
        }
        return this.name + " "  + this.requirement.getTeachingDay() + skill;
    }

}
