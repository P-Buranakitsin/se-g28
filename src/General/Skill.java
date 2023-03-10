package General;

import java.io.Serializable;

public class Skill implements Serializable {
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }
}
