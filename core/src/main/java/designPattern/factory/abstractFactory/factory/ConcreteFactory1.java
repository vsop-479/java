package designPattern.factory.abstractFactory.factory;


import designPattern.factory.abstractFactory.product.ConcreteProductA1;
import designPattern.factory.abstractFactory.product.ConcreteProductB1;
import designPattern.factory.abstractFactory.product.ProductA;
import designPattern.factory.abstractFactory.product.ProductB;

/**
 * Created by zhouhui on 2018/11/25.
 */
public class ConcreteFactory1 implements Factory {

    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}
