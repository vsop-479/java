package designPattern.strategy.quackBehavior.impl;

import designPattern.strategy.quackBehavior.QuackBehavior;

/**
 * Created by zhouhui on 2018/11/24.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
