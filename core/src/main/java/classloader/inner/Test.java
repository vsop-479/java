package classloader.inner;


public class Test {
    public static void main(String[] args){
        //初始化一个类，并不会引起其内部类的初始化。
        A a = new A();
    }
}
