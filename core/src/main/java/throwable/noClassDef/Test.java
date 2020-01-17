package throwable.noClassDef;

public class Test {
    public static void main(String args[]) {
        try{
//          类加载后，初始化时失败
//          ExceptionInInitializerError
            new User();
        }catch (Throwable t){
            t.printStackTrace();
        }

        try{
//            load，findLoadedClass时，发现加载的类，初始化失败
//            Could not initialize class throwable.noClassDef.User
            new User();
        }catch (Throwable t){
            t.printStackTrace();
        }

    }
}

class User {
    private static String id = getUserId();

    private static String getUserId() {
        throw new RuntimeException("eeeeeeee");
    }
}
