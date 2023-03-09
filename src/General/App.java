package General;

import java.util.ArrayList;
import java.util.Scanner;
import DatabaseManager.*;
<<<<<<< HEAD
import Enums.CourseName;
import Enums.SkillName;
import Enums.WorkingDay;
=======
import Utils.PopulateDB;
>>>>>>> 1eb1443ba38aaf1a04f55f511d70f43b1876346a

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
            System.out.println("[menu] Enter Role or Exit (1. Course Director, 2. Admin, 3. Exit): ");
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
        System.out.println("Enter command (1 for create, 2 for view, 3 for update, 4 for delete teacher): ");
        int command = scanner.nextInt();
        switch(command) {
            case(1):
                // to do
                // choose course to add requirement
                System.out.println("Enter course (1 for programming, 2 for SN, 3 for DB, 4 for ECS, 5 for SE ):");
                CourseName.list();
                int courseIn = scanner.nextInt();
                System.out.println("create a new teaching requirement");
                System.out.println("enter teaching day");
                WorkingDay.list();
                int workingDay = scanner.nextInt();
                System.out.println("Please specified teaching skill seperated by commas");
                SkillName.list();
                System.out.println("(1 for Java, 2 for Python,3 for SQL 4 for Assembly, 5 for Cloud_Com, 6 for Cloud_Sec, 7 for GIT, 8 for NO_SQL)");
                String skill = scanner.nextLine();
                // create teaching requirement instance
                // Course course = new Course(CourseName.values()[courseIn-1]);
                // create Course object
                //write to database manage
                
                break;
            case(2):
                // to do
                break;
            case(3):
                // to do
                CourseName.list();
                System.out.println("Enter course index to update: ");
                System.out.println("Enter field to update (1 for course name, 2 for teaching day, 3 skill): ");
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
