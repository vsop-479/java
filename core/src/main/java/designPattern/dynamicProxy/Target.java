package designPattern.dynamicProxy;

public class Target implements Foo{
    Source source;

    @Override
    public void foo() {
        doBefore();
        source.foo();
        doAfter();
    }

    public void doBefore(){
        System.out.println("do something before");
    }
    public void doAfter(){
        System.out.println("do something after");
    }
}
