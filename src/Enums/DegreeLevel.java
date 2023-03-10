package Enums;

public enum DegreeLevel {
    BACHELOR,
    MASTER,
    DOCTORAL;
    
    public static void list() {
        DegreeLevel[] degreeLevel = values();
        for (int i = 0; i < degreeLevel.length; i++) {
            System.out.println(i+1 + " for " + degreeLevel[i]);
        }
    }
    
}
