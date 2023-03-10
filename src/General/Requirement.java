package General;

import java.io.Serializable;
import java.util.ArrayList;

import Enums.WorkingDay;
import Enums.SkillName;
public class Requirement implements Serializable {
    private WorkingDay teachingDay;
    private ArrayList<Skill> skills;
    public Requirement(WorkingDay teachingDay, ArrayList<Skill> skills){
        this. teachingDay = teachingDay;
        this.skills  = new ArrayList<>();
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


    
}
