package designPattern.strategy.duck;

import designPattern.strategy.flyBehavior.FlyBehavior;
import designPattern.strategy.quackBehavior.QuackBehavior;

/**
 * Created by zhouhui on 2018/11/24.
 */
public class Duck {
//    ��ϣ�Ϊ��ͬ��Ѽ�����ò�ͬ��quackBehavior�������л�quackBehavior��
    private QuackBehavior quackBehavior;
    private FlyBehavior flyBehavior;

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("swim");
    }
}
