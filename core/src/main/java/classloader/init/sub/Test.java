package classloader.init.sub;

public class Test {
    static{
//        如果定义在后面，可以赋值，不能访问。
        i = 0;
//        System.out.println(i);Illegal forward reference
    }
    static int i = 1;
    public static void main(String[] args){
//        通过子类引用父类的静态字段，只会触发父类的初始化，而不会触发子类的初始化。
//        通过A 引用了父类Parent的静态变量value，只会出发Parent及其父类的初始化，而A不会初始化。

//        初始化：执行类构造器<clinit>方法。<clinit>方法由静态变量赋值，静态语句块组成，
//        如果一个类没有对静态变量赋值，也没有静态语句块，编译器可以不为这个类生成<client>方法。
        System.out.println(A.value);
    }
}
