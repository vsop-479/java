package designPattern.factory.abstractFactory.factory;

import designPattern.factory.abstractFactory.product.ProductA;
import designPattern.factory.abstractFactory.product.ProductB;

/**
 * Created by zhouhui on 2018/11/25.
 */
public interface Factory {
    public ProductA createProductA();
    public ProductB createProductB();
}
