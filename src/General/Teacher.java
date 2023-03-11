package General;

import java.io.Serializable;
import java.util.ArrayList;

import Enums.DegreeLevel;
import Enums.WorkingDay;
import Interfaces.*;

public class Teacher implements Storable, Serializable {
    private static int count = 0;
    private int id;
    private String firstName;
    private String lastName;
    private Degree degree;
    private ArrayList<Skill> skills;
    private ArrayList<Skill> missingSkills;
    private Course course;
    private WorkingDay availableDay;

    public Teacher(String firstName, String lastName, Degree degree, ArrayList<Skill> skills, WorkingDay availableDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        this.skills = skills;
        this.availableDay = availableDay;
        this.missingSkills = new ArrayList<>();
        this.course = null;
        this.id = ++count;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Degree getDegree() {
        return degree;
    }

    public WorkingDay getAvailableDay() {
        return availableDay;
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public void setAvailableDay(WorkingDay availableDay) {
        this.availableDay = availableDay;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Skill> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(ArrayList<Skill> missingSkills) {
        this.missingSkills = missingSkills;
    }

    @Override
    public String toString() {
        String skill = " Skills:";
        String missingSkill = " Missing Skills:";
        for (Skill s : skills) {
            skill += s.toString();
            skill += " ";
        }
        String c = " teach:";
        if (this.course != null) {
            c += this.course.getName();
        }
        else {
            c += "None";
        }
        if (missingSkills != null) {
            for (Skill ms : missingSkills) {
                missingSkill += ms.toString();
                missingSkill += " ";
            }
        }
        else {
            missingSkill += " null";
        }
        
        return  this.id + ": " + firstName + " " + lastName + " " + degree.toString() + " " + availableDay.toString() + skill + c + missingSkill;
    }
}
