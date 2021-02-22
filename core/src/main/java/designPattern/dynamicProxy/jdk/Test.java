package designPattern.dynamicProxy.jdk;

import designPattern.dynamicProxy.Foo;
import designPattern.dynamicProxy.Source;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args){
        Source source = new Source();
//        Proxy$ProxyClassFactory生成implements source interfaces, 构造方法中带有InvocationHandler的Proxy Class.
//        通过反射constructor.newInstance创建proxyInstance.
        Foo proxy = (Foo)Proxy.newProxyInstance(Source.class.getClassLoader(), Source.class.getInterfaces(), new MyInvocationHandler(source));
        proxy.foo();
    }
}
