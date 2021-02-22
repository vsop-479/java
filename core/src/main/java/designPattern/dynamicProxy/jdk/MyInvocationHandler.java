package designPattern.dynamicProxy.jdk;

import designPattern.dynamicProxy.Foo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Foo foo;
    public MyInvocationHandler(Foo foo){
        this.foo = foo;
    }
    private void doBefore(){
        System.out.println("do something before");
    }

    private void doAfter(){
        System.out.println("do something after");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object invoke = method.invoke(foo, args);
        doAfter();
        return invoke;
    }
}
