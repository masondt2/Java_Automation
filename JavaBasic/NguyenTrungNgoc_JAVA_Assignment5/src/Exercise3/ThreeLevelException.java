package Exercise3;

class BaseException extends Exception {
    public BaseException(String message) {
        super(message);
    }
}

class LevelTwoException extends BaseException {
    public LevelTwoException(String message) {
        super(message);
    }
}

class LevelThreeException extends LevelTwoException {
    public LevelThreeException(String message) {
        super(message);
    }
}

class A {
    public void ThrowMethod() throws BaseException {
        throw new BaseException("Exception from class A");
    }
}

class B extends A {
    public void ThrowMethod() throws LevelTwoException {
        throw new LevelTwoException("Exception from class B");
    }
}

class C extends B {
    public void ThrowMethod() throws LevelThreeException {
        throw new LevelThreeException("Exception from class C");
    }
}

public class ThreeLevelException {
    public static void main(String[] args) {
        try {
            A a = new C();
            a.ThrowMethod();
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block is always executed");
        }
    }
}
