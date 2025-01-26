package problem1.entities;

import java.util.ArrayList;
import java.util.List;

public class SkillList {
    private List<String> skills;

    public SkillList() {
        skills = new ArrayList<>();
        skills.add("Java");
        skills.add(".Net");
        skills.add("Android");
        skills.add("NodeJS");
        skills.add("Angular");
        skills.add("AI");
    }

    public void display() {
        System.out.println("Skill List: ");
        for (String skill : skills) {
            System.out.println(skill);
        }
    }

    public String getHead(int position) {
        if (skills == null || skills.isEmpty() || position < 0 || position >= skills.size()) {
            return null;
        }
        return skills.get(position);
    }

    public boolean remove(String skill) {
        return skills.remove(skill);
    }

    public void update(int index, String skillnew) {
        if (index >= 0 && index < skills.size()) {
            skills.set(index, skillnew);
        } else {
            System.out.println("Invalid index: " + index);
        }
    }
}
