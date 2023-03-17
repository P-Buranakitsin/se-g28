package DatabaseManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import General.*;


class TeacherManager extends DatabaseManager<Teacher> implements Serializable {

    //constructor
    protected TeacherManager() {}

    @Override
    // method to read an array list of teachers 
    public ArrayList<Teacher> readFile() { 
        String filePath = "src/Database/Teachers.tmp"; //assigning file path where the list of teachers is stored
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            try { 
                ArrayList<Teacher> teachers = (ArrayList<Teacher>) ois.readObject(); //reads the array list of teachers from the file 
                return teachers; 
            } catch (ClassNotFoundException e) { //if an exception occurs
                e.printStackTrace();   //show the stack trace
            }

        } catch (IOException e) { //if an exception occurs
            e.printStackTrace();  // show stack trace
        }
        return null; // if reading fails, return null
    }

    @Override
    //this method writes an array list of teachers to a file
    protected void writeFile(ArrayList<Teacher> teachers) {
        String filePath = "src/Database/Teachers.tmp"; //assigning file path where the list of teachers is stored
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(teachers); //write the teachers to the file
        } catch (IOException e) { //if an exception occurs
            e.printStackTrace(); //show the stack trace
        }
    }

    @Override
    //method to see teacher's information
    public void view() {
        ArrayList<Teacher> teachers = readFile(); //reading the list of teachers from the file 
        if (teachers != null) { //if the list of teachers is not empty
            for (int i = 0; i < teachers.size(); i++) { //iterate through the teachers list
                System.out.println(teachers.get(i).toString()); //and print each teacher's information
            }
        } else { // if the list of teachers is empty
            System.out.println("There is no teacher in this database.");
        }
    }

    @Override
    //method to remove a teacher from the list of teachers
    public void remove(int id) {
        ArrayList<Teacher> teachers = readFile(); //reading the list of teachers from the file 
        for (Teacher teacher : teachers) { //iterating through every teacher in the list
            if (teacher.getId() == id) { //checking if the id of the current teacher matches the id passed 
                teachers.remove(teacher); // if it does, remove the teacher from the list
                break; //terminate the loop
            }
        }
        writeFile(teachers); // write the updated list of teachers to the file
    }

    @Override
    //method to add a new teacher to the list of teachers
    public void add(Teacher teacher) {
        ArrayList<Teacher> teachers = readFile(); //reading the list of teachers from the file 
        teachers.add(teacher); //adds a new teacher to the teachers' list
        writeFile(teachers); //writing the updated teachers' list to the file
    }

    @Override
    //method to update the teacher with a certain id with a new teacher in the list
    public void edit(int id, Teacher teacher) {
        ArrayList<Teacher> teachers = readFile(); //reading the list of teachers from the file 
        for (int i = 0; i < teachers.size(); i++) { //iterating through every teacher in the list
            if(teachers.get(i).getId() == id) { //checking if the id matches
                teachers.set(i, teacher); // if it does, replace teacher at i position in the list with the new teacher
                break; //terminate the loop
            }
        }
        writeFile(teachers); // write the updated list of teachers to the file
    }
}
