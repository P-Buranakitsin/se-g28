package General;

import java.io.Serializable;
import Enums.DegreeLevel;

public class Degree implements Serializable {
    private DegreeLevel level;

    public Degree(DegreeLevel level) {
        this.level = level;
    }

    public DegreeLevel getLevel() {
        return level;
    }
}
