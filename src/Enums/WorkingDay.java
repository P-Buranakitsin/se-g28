package Enums;

public enum WorkingDay {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;

    public static void list() {
        WorkingDay[] workingDays = values();
        for (int i = 0; i < workingDays.length; i++) {
            System.out.println(i+1 + " " + workingDays[i]);
        }
    }
}

