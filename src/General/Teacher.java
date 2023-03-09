package General;

import java.io.Serializable;

import Enums.DegreeLevel;
import Interfaces.*;

public class Teacher implements Storable, Serializable {
    private String firstName;
    private String lastName;
    private Degree degree;

    public Teacher(String firstName, String lastName, DegreeLevel degreeLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = new Degree(degreeLevel);
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
}
