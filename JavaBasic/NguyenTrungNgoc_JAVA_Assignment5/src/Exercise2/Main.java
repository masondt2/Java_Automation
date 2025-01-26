package Exercise2;
/*
Create your own exception class using the extends keyword.
Write a constructor for this class that takes a String argument
and stores it inside the object with a String reference.
Write a method that prints out the stored String.
Create a try-catch clause to exercise your new exception.
 */
public class Main{
    public static void main(String[] args) throws CustomerException {
        try{
            throw new CustomerException("This is my CustomerException.");
        }catch(CustomerException e){
            e.PrintMethod();
        }finally {
            System.out.println("This is finally block. It's always running.");
        }
    }
}


class CustomerException extends Exception {
    private String message;

    public CustomerException(String message) {
        this.message = message;
    }

    public void PrintMethod(){
        System.out.println("CustomerException: "+message);
    }
}
