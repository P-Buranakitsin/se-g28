package General;

import java.util.ArrayList;
import java.util.Scanner;
import DatabaseManager.*;
import Enums.*;
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
        ArrayList<Teacher> teachers = teacherManager.readFile();
        ArrayList<Course> courses = courseManager.readFile();
        System.out.println(teachers);
        System.out.println(courses);
        scanner = new Scanner(System.in);
        while(isRun) {
            System.out.println("[menu] Enter Role or Exit (1. Course Director, 2. Admin, 3. Exit): ");
            int command = scanner.nextInt();
            scanner.nextLine();
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
                break;
            case(2):
                adminMenu();
                break;
            default:
                System.out.println("Invalid user role");
                break;
        }
    }

    private static void courseDirectorMenu() {
        boolean exit = false;
        while(!exit) {
            System.out.println("[course director] Enter command (1. for create, 2. for view, 3. for update, 4. for delete teacher, 5. for exit): ");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch(command) {
                case(1):
                    // to do
                    addTeachingRequirement();
                    break;
                case(2):
                    // to do
                    courseManager.view();
                    break;
                case(3):
                    editTeachingRequirement();
                    // to do
                    CourseName.list();
                    System.out.println("Enter course index to update: ");
                    System.out.println("Enter field to update (1 for course name, 2 for teaching day, 3 skill): ");
                    break;
                case(4):
                    // to do
                    removeTeachingRequirement();
                    break;
                case(5):
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    private static void adminMenu() {
        boolean exit = false;
        while(!exit) {
            System.out.println("[admin] Enter command (1. for teacher menu, 2. for assign teacher to course, 3. for exit): ");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch(command) {
                case(1):
                    System.out.println("[admin] Enter command (1. for create, 2. for view, 3. for update, 4. for delete teacher): ");
                    command = scanner.nextInt();
                    scanner.nextLine();
                    switch(command) {
                        case(1):
                            addTeacher();
                            break;
                        case(2):
                            teacherManager.view();
                            break;
                        case(3):
                            editTeacher();
                            break;
                        case(4):
                            removeTeacher();
                            break;
                        default:
                            System.out.println("Invalid command");
                            break;
                    }
                    break;
                case(2):
                    courseManager.view();
                    break;
                case(3):
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
        
    }

    private static void removeTeacher() {
        teacherManager.view();
        System.out.println("[admin] Enter teacher index to delete their information: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        teacherManager.remove(index);
    }

    private static void editTeacher() {
        teacherManager.view();
        System.out.println("[admin] Enter teacher index to update their information: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Teacher> teachers = teacherManager.readFile();
        System.out.println("[admin] Select a field to edit (1. for first name, 2. for last name, 3. for degree, 4. for skills, 5. for available day): ");
        int command = scanner.nextInt();
        scanner.nextLine();
        Teacher teacher = teachers.get(index-1);
        switch (command) {
            case(1):
                System.out.println("[admin] Enter teacher's first name: ");
                String firstName = scanner.nextLine();
                teacher.setFirstName(firstName);
                teacherManager.edit(index-1, teacher);
                break;
            case(2):
                System.out.println("[admin] Enter teacher's last name: ");
                String lastName = scanner.nextLine();
                teacher.setLastName(lastName);
                teacherManager.edit(index-1, teacher);
            case(3):
                System.out.println("[admin] Enter teacher's degree by the number of the following choices");
                DegreeLevel.list();
                index = scanner.nextInt();
                scanner.nextLine();
                DegreeLevel degreeLevel = DegreeLevel.values()[index-1];
                System.out.println("[admin] Enter teacher's field of study by the number of the following choices");
                FieldOfStudy.list();
                int degree = scanner.nextInt();
                scanner.nextLine();
                FieldOfStudy fieldOfStudy = FieldOfStudy.values()[degree-1];
                teacher.setDegree(new Degree(degreeLevel, fieldOfStudy));
                teacherManager.edit(index-1, teacher);
                break;
            case(4):
                System.out.println("[admin] Enter teacher's skill separated by commas, with the following choices");
                SkillName.list();
                String[] skillInputs = scanner.nextLine().split(",");
                ArrayList<Skill> skills = new ArrayList<>();
                for (String skillInput : skillInputs) {
                    SkillName skillName = SkillName.values()[Integer.parseInt(skillInput)-1];
                    Skill skill = new Skill(skillName.toString());
                    skills.add(skill);
                }
                teacher.setSkills(skills);
                teacherManager.edit(index-1, teacher);
                break;
            case(5):
                System.out.println("[admin] Enter teacher's one available day, with the following choices");
                WorkingDay.list();
                WorkingDay workingDay = WorkingDay.values()[scanner.nextInt()-1];
                scanner.nextLine();
                teacher.setAvailableDay(workingDay);
                teacherManager.edit(index-1, teacher);
                break;
            default:
                break;
        }
    }

    private static void addTeacher() {
        System.out.println("[admin] Enter teacher's first name: ");
        String firstName = scanner.nextLine();
        System.out.println("[admin] Enter teacher's last name: ");
        String lastName = scanner.nextLine();
        System.out.println("[admin] Enter teacher's degree by the number of the following choices");
        DegreeLevel.list();
        int index = scanner.nextInt();
        scanner.nextLine();
        DegreeLevel degreeLevel = DegreeLevel.values()[index-1];
        System.out.println("[admin] Enter teacher's field of study by the number of the following choices");
        FieldOfStudy.list();
        index = scanner.nextInt();
        scanner.nextLine();
        FieldOfStudy fieldOfStudy = FieldOfStudy.values()[index-1];
        System.out.println("[admin] Enter teacher's skill separated by commas, with the following choices");
        SkillName.list();
        String[] skillInputs = scanner.nextLine().split(",");
        ArrayList<Skill> skills = new ArrayList<>();
        for (String skillInput : skillInputs) {
            SkillName skillName = SkillName.values()[Integer.parseInt(skillInput)-1];
            Skill skill = new Skill(skillName.toString());
            System.out.println(skillName.toString());
            skills.add(skill);
        }
        System.out.println("[admin] Enter teacher's one available day, with the following choices");
        WorkingDay.list();
        WorkingDay workingDay = WorkingDay.values()[scanner.nextInt()-1];
        scanner.nextLine();
        Teacher teacher = new Teacher(firstName, lastName, new Degree(degreeLevel, fieldOfStudy), skills, workingDay);
        teacherManager.add(teacher);
    }
    
    public static void addTeachingRequirement(){ 
        System.out.println("[course director] Enter course:");
        CourseName.list();
        CourseName courseName = CourseName.values()[scanner.nextInt()-1];
        scanner.nextLine();
        System.out.println("[course director] Enter teaching day");
        WorkingDay.list();
        WorkingDay workingDay = WorkingDay.values()[scanner.nextInt()-1];
        scanner.nextLine();
        System.out.println("[course director] Specified teaching skill seperated by commas");
        SkillName.list();
        String[] skillInputs = scanner.nextLine().split(",");
        ArrayList<Skill> skills = new ArrayList<>();
        for (String skillInput : skillInputs) {
            SkillName skillName = SkillName.values()[Integer.parseInt(skillInput)-1];
            Skill skill = new Skill(skillName.toString());
            skills.add(skill);
        }
        Requirement requirement = new Requirement(workingDay, skills);
        Course course = new Course(courseName, requirement);
        courseManager.add(course);

    }
    public static void removeTeachingRequirement(){
        System.out.println("[course director] Select the course to remove teaching requirment:");
        courseManager.view();
        ArrayList<Course> courses = courseManager.readFile();
        Course course = courses.get(scanner.nextInt()-1);
        scanner.nextLine();
        System.out.println("[course director] Select teaching requirement to remove");
        course.getRequirement().view();
        int removeIndex = scanner.nextInt()-1;
        scanner.nextLine();
        courseManager.remove(removeIndex);
    }
    private static void editTeachingRequirement() {
        courseManager.view();
        System.out.println("[admin] Enter course index to update skill information: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Course> courses = courseManager.readFile();
        System.out.println("[admin] Select a field to edit (1. for teaching day, 2. for skill): ");
        int command = scanner.nextInt();
        scanner.nextLine();
        Course course = courses.get(index-1);
        switch (command) {
            case(1):
                System.out.println("[course director] Enter teaching day: ");
                WorkingDay.list();
                WorkingDay workingDay = WorkingDay.values()[scanner.nextInt()-1];
                course.getRequirement().setTeachingDay(workingDay);
                courseManager.edit(index-1, course);
                break;
            case(2):
                System.out.println("[course director] Enter skill separated by commas, with the following choices");
                SkillName.list();
                String[] skillInputs = scanner.nextLine().split(",");
                ArrayList<Skill> skills = new ArrayList<>();
                for (String skillInput : skillInputs) {
                    SkillName skillName = SkillName.values()[Integer.parseInt(skillInput)-1];
                    Skill skill = new Skill(skillName.toString());
                    skills.add(skill);
                }
                course.getRequirement().setSkills(skills);;
                courseManager.edit(index-1, course);
            default:
                break;
        }
    }

}
