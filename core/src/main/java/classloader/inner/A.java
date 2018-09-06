package classloader.inner;


public class A {
    static{
        System.out.println("A");
    }

    public static A getInstance(){
        return InnerA.a;
    }

    private static class InnerA{
        static{
            System.out.println("InnerA");
        }
        private static A a = new A();
    }

}
