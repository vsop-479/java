package classloader.stati;

public class StaticTest {
    public static void main(String[] args)
    {
        staticFunction();
    }
//把实例初始化嵌入到了静态初始化流程中
// 对象的初始化是顺序初始化成员变量，执行语句块，再执行构造方法
    static StaticTest st = new StaticTest();

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}
