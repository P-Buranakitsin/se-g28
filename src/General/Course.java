package General;

import Interfaces.*;

public class Course implements Storable {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
