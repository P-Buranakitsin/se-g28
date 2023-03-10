package General;

import java.io.Serializable;
import Enums.DegreeLevel;
import Enums.FieldOfStudy;

public class Degree implements Serializable {
    private DegreeLevel level;
    private FieldOfStudy field;
    
    
    public Degree(DegreeLevel level, FieldOfStudy field) {
        this.level = level;
        this.field = field;
    }

    public DegreeLevel getLevel() {
        return level;
    }
    public void setLevel(DegreeLevel Level){
        
    }

    public FieldOfStudy getField() {
        return field;
    }
    public void setField( FieldOfStudy field){
        
    }
    @Override
    public String toString() {
        return level.toString() + ", " + field.toString();

    
    
    }
}
