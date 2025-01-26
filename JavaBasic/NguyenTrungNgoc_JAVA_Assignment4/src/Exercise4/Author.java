package Exercise4;

/*
A class called Author is designed as shown in the class diagram. It contains:

Three private member variables: name (String), email (String), and gender (char of either 'm' or 'f'
- you might also use a boolean variable called isMale having value of true or false).
A constructor to initialize the name, email and gender with the given values.
(There is no default constructor, as there is no default value for name, email and gender.)

Public getters/setters: getName(), getEmail(), setEmail(), and getGender().
(There are no setters for name and gender, as these properties are not designed to be changed.)

A toString() method that returns "name (gender) at email", e.g., "Tan Ah Teck (m) at
ahTeck@somewhere.com".
 */
public class Author {
    private String name;
    private String email;
    private char gender;
    private boolean isMale;

    //Constructor
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void tostring() {
        System.out.println(this.getName() + " (" + this.getGender() + ")" + " at " + this.getEmail());
    }
}

class Main {
    public static void main(String[] args) {
        Author aut1 = new Author("Ngoc", "trungngocdt2@gmail.com", 'M');
        aut1.tostring();
    }
}
