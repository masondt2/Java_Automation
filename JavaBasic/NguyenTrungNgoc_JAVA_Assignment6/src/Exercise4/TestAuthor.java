package Exercise4;

public class TestAuthor {
    public static void main(String[] args) {
        // Create an Author object
        Author author = new Author("Nguyen Trung Ngoc", "trungngoc@somewhere.com", 'm');

        // Test getters
        System.out.println("Name: " + author.getName());
        System.out.println("Email: " + author.getEmail());
        System.out.println("Gender: " + author.getGender());

        // Test toString method
        System.out.println("Author details: " + author.toString());

        // Test setter for email
        author.setEmail("trungngoc@gmail.com");
        System.out.println("Updated Email: " + author.getEmail());

        // Test the toString method again to see updated details
        System.out.println("Updated Author details: " + author.toString());
    }
}
