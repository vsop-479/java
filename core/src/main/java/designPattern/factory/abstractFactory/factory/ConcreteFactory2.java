package designPattern.factory.abstractFactory.factory;


import designPattern.factory.abstractFactory.product.ConcreteProductA2;
import designPattern.factory.abstractFactory.product.ConcreteProductB2;
import designPattern.factory.abstractFactory.product.ProductA;
import designPattern.factory.abstractFactory.product.ProductB;

/**
 * Created by zhouhui on 2018/11/25.
 */
public class ConcreteFactory2 implements Factory {

    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB2();
    }
}
