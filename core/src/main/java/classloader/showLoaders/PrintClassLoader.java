//package classloader.showLoaders;
//
//import com.sun.javafx.util.Logging;
//
//import java.util.HashMap;
//
//public class PrintClassLoader {
//    public static void main(String[] args)
//    {
//        System.out.println("ClassLoader of PrintClassLoader: " + PrintClassLoader.class.getClassLoader());
//        System.out.println("ClassLoader of Logging: " + Logging.class.getClassLoader());
//        System.out.println("ClassLoader of HashMap: " + HashMap.class.getClassLoader());
//
//        ClassLoader classLoader = PrintClassLoader.class.getClassLoader();
//        while (classLoader != null){
//            System.out.println(classLoader);
//            classLoader = classLoader.getParent();
//        }
//    }
//}
