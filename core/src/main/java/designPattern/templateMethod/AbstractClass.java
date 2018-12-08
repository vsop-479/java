package designPattern.templateMethod;

/**
 * Created by zhouhui on 2018/12/8.
 */
public abstract class AbstractClass {

    final void templateMethod(){
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        hook();
    }

    abstract void primitiveOperation1();

    abstract void primitiveOperation2();

    final void concreteOperation(){
//        concreteOperation
    }

    void hook(){}
}
