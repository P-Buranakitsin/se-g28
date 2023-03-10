package Enums;

public enum FieldOfStudy {
    COMPUTING_SCIENCE,
    PHYSICS,
    CHEMISTRY,
    MATHS;
    
    public static void list() {
        FieldOfStudy[] fieldOfStudies = values();
        for (int i = 0; i < fieldOfStudies.length; i++) {
            System.out.println(i+1 + " for " + fieldOfStudies[i]);
        }
    }
    
}
