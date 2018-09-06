package classloader.inner;

public class A {
    static{
        System.out.println("A");
    }

    private static class InnerA{
        static{
            System.out.println("InnerA");
        }
    }

}
