package Exercise3;
/*
Write a Java program to create a Stack data structure.
This Stack data structure is to store the integer values.
Your program should display a menu of choices to operate the Stack data structure.
See the sample menu below:
==================================================
Stack Operations Menu
==================================================
1. Add items
2. Delete items
3. Show the number of items
4. Show min and max items
5. Find an item
6. Print all items
7. Exit
Enter your choice:1
 */

import java.util.ArrayList;
import java.util.Collections;

public class StackData {
    private ArrayList<Integer> stack;

    public StackData() {
        stack = new ArrayList<>();
    }

    //Add items
    public void push(int value) {
        stack.add(value);
    }

    //Delete item
    public Integer pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty. Cannot delete item.");
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    //Show the number of items
    public int Size() {
        return stack.size();
    }

    //Show the min item
    public Integer getMin() {
        return stack.isEmpty() ? null : Collections.min(stack);
    }

    //Show the max item
    public Integer getMax() {
        return stack.isEmpty() ? null : Collections.max(stack);
    }

    //Find an item in the stack
    public boolean FindItem(int item) {
        return stack.contains(item);
    }

    //Print all items
    public void PrintStack() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack items: " + stack);
        }
    }
}
