package classloader.showLoaders;

import java.util.HashMap;

public class PrintClassLoader {
    public static void main(String[] args)
    {
        System.out.println("ClassLoader of PrintClassLoader: " + PrintClassLoader.class.getClassLoader());
        System.out.println("ClassLoader of HashMap: " + HashMap.class.getClassLoader());

        ClassLoader classLoader = PrintClassLoader.class.getClassLoader();
        while (classLoader != null){
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }
}
