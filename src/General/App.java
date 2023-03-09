package General;

import java.util.ArrayList;
import java.util.Scanner;
import DatabaseManager.*;
import Utils.PopulateDB;

public class App {
    private static DatabaseManager<Teacher> teacherManager;
    private static DatabaseManager<Course> courseManager;
    private static Scanner scanner;

    public static void main(String[] args) {
        boolean isRun = true;
        DatabaseManagerFactory databaseManagerFactory = new DatabaseManagerFactory();
        teacherManager = databaseManagerFactory.getTeacherManager();
        courseManager = databaseManagerFactory.getCourseManager();
        PopulateDB.poulateTeachersDB();
        PopulateDB.populateCoursesDB();
        ArrayList<Teacher> teachers = teacherManager.readFile(null);
        ArrayList<Course> courses = courseManager.readFile(null);
        System.out.println(teachers);
        System.out.println(courses);
        scanner = new Scanner(System.in);
        while(isRun) {
            System.out.println("[menu] Enter 3Role or Exit (1. Course Director, 2. Admin, 3. Exit): ");
            int command = scanner.nextInt();
            if(command == 3) {
                isRun = false;
            }
            else {
                commandProcessor(command);
            }
        }
    }

    public static void commandProcessor(int userRole) {
        switch(userRole) {
            case(1):
                courseDirectorMenu();
            case(2):
                adminMenu();
            default:
                System.out.println("Invalid user role");
                break;
        }
    }

    private static void courseDirectorMenu() {
        System.out.println("Enter command (1 for create, 2 for view course): ");
        int command = scanner.nextInt();
        switch(command) {
            case(1):
                // to do
                break;
            case(2):
                // to do
                break;
            case(3):
                // to do
                break;
            case(4):
                // to do
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
    }

    private static void adminMenu() {
        System.out.println("Enter command (1 for teacher menu, 2 for assign teacher to course): ");
        int command = scanner.nextInt();
        switch(command) {
            case(1):
                System.out.println("Enter command (1 for create, 2 for view, 3 for update, 4 for delete teacher): ");
                command = scanner.nextInt();
                switch(command) {
                    case(1):
                        // to do
                        break;
                    case(2):
                        // to do
                        break;
                    case(3):
                        // to do
                        break;
                    case(4):
                        // to do
                        break;
                    default:
                        System.out.println("Invalid command");
                        break;
                }
            case(2):
                System.out.println("Select course to fill teacher");
                // to do
                int selectedTeachingRequirement = scanner.nextInt();
                // to do
            default:
                System.out.println("Invalid user role");
                break;
        }
    }

    
    
}
