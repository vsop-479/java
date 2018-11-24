package designPattern.decorator.decorator;

import designPattern.decorator.component.Component;

/**
 * Created by zhouhui on 2018/11/24.
 */
public class ConcreteDecorator implements Decorator {
    private Component component;

    @Override
    public void a() {
        doDecorator();
        component.a();
    }

    public void doDecorator(){
        System.out.println("doDecorator");
    }
}
