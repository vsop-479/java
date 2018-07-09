package classloader.init.constant;

public class Test {
    public static void main(String[] args){
//        引用常量，不会触发类初始化。
//        常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，
//        因此不会触发定义常量的类的初始化。
        System.out.println(A.HELLO_WORLD);
    }
}
