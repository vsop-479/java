package classloader.init.sub;

public class Parent extends GrandParent {
    static{
        System.out.println("Parent");
    }

    public static int value = 123;
}
