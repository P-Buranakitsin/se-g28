package General;

import java.io.Serializable;
import java.util.ArrayList;

import Enums.DegreeLevel;
import Enums.WorkingDay;
import Interfaces.*;

public class Teacher implements Storable, Serializable {
    private String firstName;
    private String lastName;
    private Degree degree;
    private ArrayList<Skill> skills;
    private Course course;
    private WorkingDay availableDay;

    public Teacher(String firstName, String lastName, Degree degree, ArrayList<Skill> skills, WorkingDay availableDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        this.skills = new ArrayList<>();
        this.availableDay = availableDay;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + degree.toString();
    }
}
