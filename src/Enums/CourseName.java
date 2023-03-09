package Enums;

public enum CourseName {
    PROGRAMMING,
    SYSTEMS_AND_NETWORK,
    DATABASE,
    ENTERPRISE_CYBER_SECURITY,
    SOFTWARE_ENGINEERING;
    public static void list() {
        CourseName[] courseNames = values();
        for (int i = 0; i < courseNames.length; i++) {
            System.out.println(i+1 + " " + courseNames[i]);
        }
    }
    
}

