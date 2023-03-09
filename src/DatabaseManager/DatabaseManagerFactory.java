package DatabaseManager;

import Enums.*;

public class DatabaseManagerFactory {

    public DatabaseManager getDatabaseManager(DatabaseManagerType databaseManagerType) {
        switch (databaseManagerType) {
            case TEACHER:
                return new TeacherManager();
            case COURSE:
                return new CourseManager();
            default:
                throw new IllegalArgumentException();
        }
    }
    
}
