package General;

import java.io.Serializable;
import java.util.ArrayList;

import Enums.*;
public class Requirement implements Serializable {
    private WorkingDay teachingDay;
    private ArrayList<Skill> skills;
    private Degree degree;

    public Requirement(WorkingDay teachingDay, ArrayList<Skill> skills, Degree degree){
        this.teachingDay = teachingDay;
        this.skills  = skills;
        this.degree = degree;
    }

    public void view() {
        for (int i = 0; i < skills.size(); i++){
            System.out.println(i+1 + ":" +this.skills.get(i));
        }
    
    }
    
    public ArrayList<Skill> getSkills() {
        return skills;
    }
    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
    public void setTeachingDay(WorkingDay teachingDay) {
        this.teachingDay = teachingDay;
    }
    public WorkingDay getTeachingDay() {
        return teachingDay;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Degree getDegree() {
        return degree;
    }
}
