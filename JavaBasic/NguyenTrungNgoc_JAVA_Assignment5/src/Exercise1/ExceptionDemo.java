package Exercise1;

public class ExceptionDemo {
    public static void main(String[] args) throws Exception {
        try{
            throw new Exception("This is a exception message.");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Finally block always run.");
        }
    }
}
