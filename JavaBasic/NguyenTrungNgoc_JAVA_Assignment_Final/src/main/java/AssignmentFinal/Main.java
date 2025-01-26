package AssignmentFinal;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Creat visits
        Visit visit1 = new Visit(new Customer("Ngoc").getName(),new Date());
        visit1.setMember(true);
        visit1.setMemberType("Premium");
        visit1.setServiceExpense(100.0);
        visit1.setProductExpense(200.0);

        Visit visit2 = new Visit(new Customer("Huong").getName(),new Date());
        visit2.setMember(true);
        visit2.setMemberType("Gold");
        visit2.setServiceExpense(150.0);
        visit2.setProductExpense(220.0);

        Visit visit3 = new Visit(new Customer("Lan").getName(),new Date());
        visit3.setMember(true);
        visit3.setMemberType("Silver");
        visit3.setServiceExpense(250.0);
        visit3.setProductExpense(300.0);

        Visit visit4 = new Visit(new Customer("Long").getName(),new Date());
        visit4.setServiceExpense(110.0);
        visit4.setProductExpense(50.0);

        Visit visit5 = new Visit(new Customer("Hoang Anh").getName(),new Date());
        visit5.setMemberType("Premium");
        visit5.setServiceExpense(120.0);
        visit5.setProductExpense(80.0);

        //Print all visits
        System.out.println(visit1);
        System.out.println(visit2);
        System.out.println(visit3);
        System.out.println(visit4);
        System.out.println(visit5);
    }
}
