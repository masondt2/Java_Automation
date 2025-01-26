package problem1.mangement;

import problem1.entities.SkillList;

public class SkillManagement {
    public static void main(String[] args) {
        SkillList skillList = new SkillList();

        System.out.println("Initial Skill List:");
        skillList.display();

        //Test getHead
        System.out.println("Element at position 2:" + skillList.getHead(2));
        System.out.println("Element at position 9:" + skillList.getHead(9));

        //Test remove() method
        boolean removedElement = skillList.remove(".Net");
        System.out.println("Removed .Net: " + removedElement);

        //Test update() method
        skillList.update(1, "Python");
        System.out.println("After Update: ");
        skillList.display();

        //Test update invalid index
        skillList.update(10, "C#");

    }
}
