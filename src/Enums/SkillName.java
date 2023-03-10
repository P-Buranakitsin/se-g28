package Enums;

import java.io.Serializable;

public enum SkillName implements Serializable {
    JAVA,
    PYTHON,
    SQL,
    ASSEMBLY,
    CLOUD_COMPUTING,
    CLOUD_SECURITY,
    GIT,
    NO_SQL;
    
    public static void list() {
        SkillName[] skillNames = values();
        for (int i = 0; i < skillNames.length; i++) {
            System.out.println(i+1 + " for " + skillNames[i]);
        }
    }
}
