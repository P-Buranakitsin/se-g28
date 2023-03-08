public class DatabaseManagerFactory {
    public DatabaseManager getDatabaseManager(String databaseType) {
        switch (databaseType) {
            case "TEACHER":
                return new TeacherManager(null, null);
            case "COURSE":
                return new CourseManager(null, null);
            case "DEFAULT":
                return new DatabaseManager(null, null);
            default:
                return new DatabaseManager(null, null);
        }
    }
}
