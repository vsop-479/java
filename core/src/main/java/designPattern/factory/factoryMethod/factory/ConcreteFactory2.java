package designPattern.factory.factoryMethod.factory;

import designPattern.factory.factoryMethod.product.ConcreteProduct2;
import designPattern.factory.factoryMethod.product.Product;

/**
 * Created by zhouhui on 2018/11/25.
 */
public class ConcreteFactory2 implements Factory{
    public Product createProduct(){
        return new ConcreteProduct2();
    }
}
