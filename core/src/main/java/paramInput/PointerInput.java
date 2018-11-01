package paramInput;

public class PointerInput {
    public static void f(A a){
        //2：将传来的拷贝赋新的地址
        a = new A();
        a.setName("fffff");
        System.out.println(a.getName());
    }

    public static void main(String[] args){
        A a = new A();
        a.setName("aaaa");
        //1：传递的是地址值的拷贝
        f(a);
//        3：还是原来的地址
        System.out.println(a.getName());
    }
}

class A {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}