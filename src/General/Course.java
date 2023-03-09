package General;

import java.io.Serializable;

import Enums.*;
import Interfaces.*;

public class Course implements Storable, Serializable {
    private CourseName name;

    public Course(CourseName name) {
        this.name = name;
    }

    public CourseName getName() {
        return this.name;
    }

    public void setName(CourseName name) {
        this.name = name;
    }
}
