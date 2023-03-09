package DatabaseManager;

import General.*;

public class DatabaseManagerFactory {

    public DatabaseManager<Teacher> getTeacherManager() {
        return new TeacherManager();
    }

    public DatabaseManager<Course> getCourseManager() {
        return new CourseManager();
    }

}
