package exercise2;

public class CheckPassFail {
    private int mark;

    public void checkPassFail(int mark) {
        this.mark = mark;
        if(mark>=50){
            System.out.println("PASS");
        }
        else System.out.println("FAIL");
    }
}
