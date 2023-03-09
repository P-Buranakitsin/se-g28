package Enums;

public enum SkillName {
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
            System.out.println(i+1 + " " + skillNames[i]);
        }
    }
}
