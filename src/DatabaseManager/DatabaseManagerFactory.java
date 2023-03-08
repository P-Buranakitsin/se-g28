package DatabaseManager;

import Enums.*;

public class DatabaseManagerFactory {

    public DatabaseManager getDatabaseManager(DatabaseManagerType databaseManagerType) {
        switch (databaseManagerType) {
            case TEACHER:
                return new TeacherManager(null, null);
            case COURSE:
                return new CourseManager(null, null);
            case BASE:
                return new DatabaseManager(null, null);
            default:
                return new DatabaseManager(null, null);
        }
    }
    
}
