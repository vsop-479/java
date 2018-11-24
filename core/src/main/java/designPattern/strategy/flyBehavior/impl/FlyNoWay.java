package designPattern.strategy.flyBehavior.impl;

import designPattern.strategy.flyBehavior.FlyBehavior;

/**
 * Created by zhouhui on 2018/11/24.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("FlyNoWay");
    }
}
