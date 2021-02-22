package designPattern.dynamicProxy;

public class Source implements Foo{
    @Override
    public void foo() {
        System.out.println("Source foo");
    }
}
