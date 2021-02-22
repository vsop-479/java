//package unsafe;
//
//import sun.misc.Unsafe;
//import java.lang.reflect.Field;
//
//public class Test {
//    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//    }
//
//    /**
//     *  直接get会有权限问题
//     *  java.lang.SecurityException: Unsafe
//     * @return
//     */
//    public static Unsafe getSecurityException(){
//        Unsafe u = Unsafe.getUnsafe();
//        return u;
//    }u
//
//    /**
//     *  适用反射获取field
//      * @return
//     * @throws NoSuchFieldException
//     * @throws IllegalAccessException
//     */
//    public static Unsafe getReflect() throws NoSuchFieldException, IllegalAccessException {
//        Class<Unsafe> unsafeClass = Unsafe.class;
//        Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
//        theUnsafe.setAccessible(true);
//        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
//        return unsafe;
//    }
//}
